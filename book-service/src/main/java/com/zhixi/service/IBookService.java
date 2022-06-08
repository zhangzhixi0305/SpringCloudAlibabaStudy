package com.zhixi.service;

import com.zhixi.pojo.Book;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName IBookService
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 18:53
 * @Version 1.0
 */
public interface IBookService {
    Book getBookById(int bid);

    boolean setRemain(int bid, int count);

    int getRemain(int bid);
}
