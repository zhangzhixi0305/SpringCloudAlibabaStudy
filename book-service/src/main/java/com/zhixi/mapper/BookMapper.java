package com.zhixi.mapper;

import com.zhixi.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @ClassName BookMapper
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 18:52
 * @Version 1.0
 */
@Mapper
public interface BookMapper {

    @Select("select * from DB_BOOK where bid = #{bid}")
    Book getBookById(@Param("bid") int bid);


    /**
     * 查询书籍数量
     *
     * @param bid 书籍id
     * @return 可借阅的书籍数量
     */
    @Select("select count from DB_BOOK  where bid = #{bid}")
    int getRemain(@Param("bid") int bid);

    /**
     * 更新书籍的可借阅数量
     *
     * @param bid   书籍id
     * @param count 可借阅数量
     * @return 更新可借阅书籍的数量
     */
    @Update("update DB_BOOK set count = #{count}  where bid = #{bid}")
    int setRemain(@Param("bid") int bid, @Param("count") int count);
}
