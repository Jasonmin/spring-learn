package com.mysql;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("select id as bookId, title as bookTitle,price,publishDate from books")
    List<Book> getBookList();

    @Select("select id as bookId, title as bookTitle,price,publishDate from books limit #{pageCount},#{pageSize}")
    List<Book> getPageBook(@Param("pageCount") int pageCount, @Param("pageSize") int pageSize);

    @Select("select id as bookId, title as bookTitle,price,publishDate from books where id = #{id} ")
    Book findBook(@Param("id") int id);

    @Insert("insert into books(title,price) values(#{title},#{price})")
    int addBook(@Param("title") String title, @Param("price") double price);

}
