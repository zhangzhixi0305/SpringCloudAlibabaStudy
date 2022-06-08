package com.zhixi.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhixi.pojo.Borrow;
import com.zhixi.pojo.UserBorrowDetail;
import com.zhixi.service.IBorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName BorrowController
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 19:50
 * @Version 1.0
 */
@RestController
public class BorrowController {

    @Resource
    IBorrowService service;

    /**
     * 根据用户ID查询出是哪个用户借阅了哪些书籍
     *
     * @param uid 用户id
     * @return 用户借阅的书籍
     */
    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") int uid) {
        return service.getUserBorrowDetailByUid(uid);
    }


    /**
     * 根据用户id和书籍id获取借阅记录
     *
     * @param uid 用户id
     * @param bid 书籍id
     * @return 借阅记录
     */
    @RequestMapping("/borrow/{uid}/{bid}")
    public Borrow getBorrowToUidBid(@PathVariable("uid") int uid, @PathVariable("bid") int bid) {
        return service.getBorrowToUidBid(uid, bid);
    }

    /**
     * 用户借阅图书
     * @param uid 用户id
     * @param bid 书籍id
     * @return 如果用户没有借阅过此书籍，书籍数量-1
     */
    @RequestMapping("/borrow/take/{uid}/{bid}")
    JSONObject borrow(@PathVariable("uid") int uid,
                      @PathVariable("bid") int bid){
        service.doBorrow(uid, bid);

        JSONObject object = new JSONObject();
        object.put("code", "200");
        object.put("success", false);
        object.put("message", "借阅成功！");
        return object;
    }
}
