package com.zhixi.controller;

import com.zhixi.pojo.Book;
import com.zhixi.service.IBookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName BookController
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 18:55
 * @Version 1.0
 */
@RestController
public class BookController {

    @Resource
    IBookService service;

    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") int bid) {
        System.out.println("book-findBookById接口被调用了~");
        return service.getBookById(bid);
    }

    @RequestMapping("/book/remain/{bid}")
    public int bookRemain(@PathVariable("bid") int uid) {
        return service.getRemain(uid);
    }

    @RequestMapping("/book/borrow/{bid}")
    public boolean bookBorrow(@PathVariable("bid") int uid) {
        int remain = service.getRemain(uid);
        return service.setRemain(uid, remain - 1);
    }
}
