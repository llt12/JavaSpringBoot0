package com.itheima;

import com.itheima.controller.BookController;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springbootstart01ApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        Book book = bookDao.selectById(15);
        System.out.println(book);

    }


//    @Test
//    void  getall(){
//        Book book=new Book();
//        controller.getPage(book);
//    }


}
