package com.book;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Book3Mapper {

    @Select("select id as uid,title,imgPath,linkUrl from ziran limit #{pageCount},#{pageSize}")
    List<Book> getBookList(@Param("pageCount") int pageCount, @Param("pageSize") int pageSize);

    @Select("select * from ziran where concat(title,imgPath,linkUrl) like '%${text}%'")
    List<Book> searchBookList(@Param("text") String text);

    @Insert("insert into ziran(title,imgPath,linkUrl) values(#{title},#{imgPath},'')")
    int insertNewBook(String title, String imgPath);

    @Update("update ziran set title=#{title},imgPath=#{imgPath},linkUrl='' where id=#{uid}")
    void updateBook(int uid,String title, String imgPath);

    @Delete("delete from ziran where id=#{uid}")
    void removeBook(int uid);


}
