package com.zhixi.service.impl;

import com.zhixi.mapper.BorrowMapper;
import com.zhixi.pojo.Book;
import com.zhixi.pojo.Borrow;
import com.zhixi.pojo.User;
import com.zhixi.pojo.UserBorrowDetail;
import com.zhixi.service.IBorrowService;
import com.zhixi.service.client.BookClient;
import com.zhixi.service.client.UserClient;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName BorrowServiceImpl
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 19:27
 * @Version 1.0
 */
@Service
public class BorrowServiceImpl implements IBorrowService {

    @Resource
    BorrowMapper mapper;


    @Resource
    UserClient userClient;

    @Resource
    BookClient bookClient;

    /**
     * 获取某一个用户借阅的全部数据
     *
     * @param uid 用户ID
     * @return 用户借阅的全部数据
     */
    @Override
    //指定blockHandler，也就是被限流之后的替代解决方案，这样就不会使用默认的抛出异常的形式了
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);

        //RestTemplate支持多种方式的远程调用
        /*RestTemplate template = new RestTemplate();*/
        //这里通过调用getForObject来请求其他服务，并将结果自动进行封装
        //获取User信息
        User user = userClient.findUserById(uid);
        //获取每一本书的详细信息
        List<Book> bookList = borrow
                .stream()
                .map(b -> bookClient.findBookById(b.getBid()))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }

    @GlobalTransactional
    @Override
    public boolean doBorrow(int uid, int bid) {
        //1. 判断图书和用户是否都支持借阅
        if (bookClient.bookRemain(bid) < 1) {
            throw new RuntimeException("图书数量不足");
        }
        if (userClient.userRemain(uid) < 1) {
            throw new RuntimeException("用户借阅量不足");
        }
        //2. 首先将图书的数量-1
        if (!bookClient.bookBorrow(bid)) {
            throw new RuntimeException("在借阅图书时出现错误！");
        }
        //3. 添加借阅信息
        if (mapper.getBorrow(uid, bid) != null) {
            throw new RuntimeException("此书籍已经被此用户借阅了！");
        }
        if (mapper.addBorrow(uid, bid) <= 0) {
            throw new RuntimeException("在录入借阅信息时出现错误！");
        }
        //4. 用户可借阅-1
        if (!userClient.userBorrow(uid)) {
            throw new RuntimeException("在借阅时出现错误！");
        }
        //完成
        return true;
    }

    @Override
    public Borrow getBorrowToUidBid(int uid, int bid) {
        return mapper.getBorrowToUidBid(uid, bid);
    }
}
