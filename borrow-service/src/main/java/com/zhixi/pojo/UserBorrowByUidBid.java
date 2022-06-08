package com.zhixi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserBorrowByUidBid
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 20:45
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBorrowByUidBid {
    User user;
    Book book;
}
