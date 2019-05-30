package com.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Book>getBookList() {

        return bookMapper.getBookList();
    }

    public List<Book>getPageBook(int pageIdx, int pageSize) {
        int pageCount = pageIdx*pageSize;
        return bookMapper.getPageBook(pageCount,pageSize);
    }

    public Book findBookById(int id) {
        return bookMapper.findBook(id);
    }

    public int addBook(String title,double price) {
        return bookMapper.addBook(title,price);
    }

    @Controller
    public static class SimpleController {

        @Value("${spring.application.name}")
        String appName;

        @GetMapping("/")
        public String homePage(Model model) {
            model.addAttribute("appName",appName);
            return "home";
        }

        @RequestMapping(value = "/home",method = RequestMethod.GET)
        public String home(Model model) {
            model.addAttribute("appName",appName);
            return "home";
        }

        @GetMapping("/hello")
        public String hello() {
            return "hello";
        }

        @RequestMapping(value = "/test",method = RequestMethod.GET)
        public String test() {
            return "test";
        }
    }
}
