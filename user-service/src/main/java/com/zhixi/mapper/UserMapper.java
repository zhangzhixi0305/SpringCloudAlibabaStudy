package com.zhixi.mapper;

import com.zhixi.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @ClassName UserMapper
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 18:42
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    @Select("select * from DB_USER where uid = #{uid}")
    User getUserById(@Param("uid") int uid);

    @Select("select book_count from DB_USER where uid = #{uid}")
    int getUserBookRemain(int uid);


    /**
     * 更新用户的可借阅图书数量
     *
     * @param uid       用户id
     * @param bookCount 可借阅图书数量
     * @return true：1 false：0
     */
    @Update("update DB_USER set book_count = #{count} where uid = #{uid}")
    int updateBookCount(@Param("uid") int uid, @Param("count") int bookCount);


    @Update("update db_user set book_count = #{book_count} where uid = #{uid}")
    int updateUser(@Param("uid") int uid, @Param("book_count") int bookCount);
}
