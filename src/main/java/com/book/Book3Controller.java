package com.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book3")
public class Book3Controller {

    @Autowired
    Book3Service book3Service;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() {
        return "hello world";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Book> getBookList(@RequestParam(value = "pageIdx") int pageIdx,
                                  @RequestParam(value = "pageSize") int pageSize) {
        List<Book> bookList = book3Service.getBookList(pageIdx, pageSize);
        return bookList;
    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public List<Book> searchBookList(@RequestParam(value = "text") String text) {
        List<Book> bookList = book3Service.searchBookList(text);
        return bookList;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String insertNewBook(@RequestParam(value = "title") String title,
                                @RequestParam(value = "imgPath") String imgPath) {
        return book3Service.insertNewBook(title,imgPath);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void updateBook(@RequestParam(value = "uid") int uid,
                           @RequestParam(value = "title") String title,
                           @RequestParam(value = "imgPath") String imgPath) {
        book3Service.updateBook(uid,title,imgPath);
    }

    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public void removeBook(@RequestParam(value = "uid") int uid) {
        book3Service.removeBook(uid);
    }

}
