package com.zhixi.service;

import com.zhixi.pojo.Borrow;
import com.zhixi.pojo.UserBorrowDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName IBorrowService
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 19:18
 * @Version 1.0
 */
public interface IBorrowService {

    /**
     * 获取某一个用户借阅的全部数据
     *
     * @param uid 用户id
     * @return 某用户借阅的全部数据
     */
    UserBorrowDetail getUserBorrowDetailByUid(int uid);

    /**
     * 根据用户id和书籍id获取借阅记录
     *
     * @param uid 用户id
     * @param bid 书籍id
     * @return 借阅记录
     */
    Borrow getBorrowToUidBid(int uid, @Param("bid") int bid);


    boolean doBorrow(int uid, int bid);

}
