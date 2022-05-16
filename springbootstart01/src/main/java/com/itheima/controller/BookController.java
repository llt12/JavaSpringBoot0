package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService service;

    @GetMapping
    public R getAll() {
        return new R(true, service.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws Exception {
        boolean flag = service.save(book);

//        添加失败条件
        if (book.getName().equals("123")) throw new Exception();


        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(service.updateById(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(service.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, service.getById(id));
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize) {
//        IPage<Book> bookIPage = service.getPage(currentPage, pageSize);
//
//        if (currentPage>bookIPage.getPages()){
//            bookIPage=service.getPage((int)bookIPage.getPages(),pageSize);
//        }
//
//        return new R(null!=bookIPage,bookIPage );
//    }


//    分页查询
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize,Book book) {

        IPage<Book> bookIPage = service.getPage(currentPage, pageSize,book);
        System.out.println("Book=====================>"+book);
        if (currentPage>bookIPage.getPages()){
            bookIPage=service.getPage((int)bookIPage.getPages(),pageSize,book);
        }

//        bookIPage=service.getPage((int)bookIPage.getPages(),pageSize,book);

//        return new R(true,bookIPage );
        return new R(null !=bookIPage,bookIPage );//
    }
}
