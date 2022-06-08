package com.zhixi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @ClassName UserBorrowDetail
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 19:23
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class UserBorrowDetail {
    User user;
    List<Book> bookList;
}
