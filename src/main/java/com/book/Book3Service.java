package com.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Book3Service {

    @Autowired
    private Book3Mapper book3Mapper;

    public List<Book>getBookList(int pageIdx, int pageSize) {
        int pageCount = pageIdx * pageSize;

        return book3Mapper.getBookList(pageCount,pageSize);
    }

    public List<Book>searchBookList(String text) {

        return book3Mapper.searchBookList(text);
    }

    public String insertNewBook(String title, String imgPath) {

        int res = book3Mapper.insertNewBook(title,imgPath);
        if (res == 1) {
            return "add success";
        } else {
            return "add fail";
        }
    }

    public void updateBook(int uid,String title, String imgPath) {

        book3Mapper.updateBook(uid,title,imgPath);
    }

    public void removeBook(int uid) {

        book3Mapper.removeBook(uid);
    }


}
