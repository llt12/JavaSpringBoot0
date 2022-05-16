package com.itheima.controller.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService service;

    @GetMapping
    public List<Book> getAll(){
        return service.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book){
        return service.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return service.updateById(book);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return service.removeById(id);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){
      return service.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(int currentPage,int pageSize){

        return service.getPage(currentPage,pageSize);
    }
}
