package com.zhixi.mapper;

import com.zhixi.pojo.Borrow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName BorrowMapper
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 19:16
 * @Version 1.0
 */
@Mapper
public interface BorrowMapper {
    /**
     * 通过用户id获取借阅记录
     *
     * @param uid 用户id
     * @return 借阅记录
     */
    @Select("select * from DB_BORROW where uid = #{uid}")
    List<Borrow> getBorrowsByUid(@Param("uid") int uid);

    /**
     * 根据用户id和书籍id获取借阅记录
     *
     * @param uid 用户id
     * @param bid 书籍id
     * @return 借阅记录
     */
    @Select("select * from DB_BORROW where uid = #{uid} and bid = #{bid}")
    Borrow getBorrowToUidBid(@Param("uid") int uid, @Param("bid") int bid);


    @Select("select * from DB_BORROW where bid = #{bid} and uid = #{uid}")
    Borrow getBorrow(@Param("uid") int uid, @Param("bid") int bid);

    @Insert("insert into DB_BORROW(uid,bid) values(#{uid},#{bid})")
    int addBorrow(@Param("uid") int uid, @Param("bid") int bid);
}
