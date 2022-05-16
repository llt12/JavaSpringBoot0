package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import com.itheima.service.impl.BookServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private BookServiceImpl serviceImp;

    @Test
    void getById(){
        Book byId = serviceImp.getById(15);
        System.out.println(byId);
    }

    @Test
    void getPageTest(){
//        LambdaQueryWrapper<Book> wrapper=new LambdaQueryWrapper<>();
//        wrapper.like(Strings.isEmpty(book.getType()),Book::getType,book.getType());
//        wrapper.like(Strings.isEmpty(book.getName()),Book::getName,book.getName());
//        wrapper.like(Strings.isEmpty(book.getDescription()),Book::getDescription,book.getDescription());
//        IPage page=new Page(Integer currentPage,Integer pageSize);
//        bookDao.selectPage(page,wrapper);
//        Book book=new Book("文化课","历史","世界史");
////        String type="实践课";
//        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<>();
////        lqw.like(type!=null,Book::getType,type);
//        IPage<Book> page=new Page<>(1,5);
//        IPage<Book> page1 = bookService.page(page, lqw);
//        page.getRecords();
    }

    @Test
    void getPageServiceTest(){

        Book book=new Book();

        LambdaQueryWrapper<Book> wrapper=new LambdaQueryWrapper<>();
        wrapper.like(Strings.isEmpty(book.getType()), Book::getType,"文化课");
        wrapper.like(Strings.isEmpty(book.getName()), Book::getName,"历史");
        wrapper.like(Strings.isEmpty(book.getDescription()), Book::getDescription,"世界史");

//        IPage<Book> page=new Page<>(1,10);
        IPage<Book> page=new Page<>(1,9);

        IPage<Book> page1 = serviceImp.page(page, wrapper);

        List<Book> records = page1.getRecords();

        System.out.println("======================="+records);
    }


}
