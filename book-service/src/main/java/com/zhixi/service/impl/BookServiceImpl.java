package com.zhixi.service.impl;

import com.zhixi.mapper.BookMapper;
import com.zhixi.pojo.Book;
import com.zhixi.service.IBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName BookServiceImpl
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 18:54
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements IBookService {

    @Resource
    BookMapper mapper;

    @Override
    public Book getBookById(int bid) {
        return mapper.getBookById(bid);
    }


    /**
     * 查询书籍数量
     *
     * @param bid 书籍id
     * @return 可借阅的书籍数量
     */
    @Override
    public int getRemain(int bid) {
        return mapper.getRemain(bid);
    }


    /**
     * 更新书籍的可借阅数量
     *
     * @param bid   书籍id
     * @param count 可借阅数量
     * @return 更新可借阅书籍的数量
     */
    @Override
    public boolean setRemain(int bid, int count) {
        return mapper.setRemain(bid, count) > 0;
    }
}
