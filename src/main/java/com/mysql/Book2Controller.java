package com.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/book")
public class Book2Controller {

    @Autowired
    BookService bookService;

    @Autowired
    ResWrapper resWrapper;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseResult getBooks() {
        List<Book> dataList = bookService.getBookList();
        boolean res = true;
        if (dataList == null) {
            res = false;
        }
//        return resWrapper.wrapResultData(res,dataList);

        return new ResponseResult(0,res,"msg",dataList);
    }


    @RequestMapping(value = "/abook/{id}",method = RequestMethod.GET)
    public Book getBookById(@PathVariable("id") int bookId) {
        return bookService.findBookById(bookId);
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public HashMap<String,Object> addBook(@RequestParam(value = "title") String title,
                                          @RequestParam(value = "price") double price) {

        int res = bookService.addBook(title,price);
        return resWrapper.wrapResultData(res,null);
    }

    @RequestMapping(value = "/pageList", method = RequestMethod.POST)
    public HashMap<String,Object> getPageBooks(@RequestParam(value = "pageIdx") int pageIdx,
                                               @RequestParam(value = "pageSize") int pageSize) {
        List<Book> dataList = bookService.getPageBook(pageIdx,pageSize);
        int res = 1;
        if (dataList == null) {
            res = 0;
        }
        return resWrapper.wrapResultData(res,dataList);
    }

}
