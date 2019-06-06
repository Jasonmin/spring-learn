package com.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jbook")
public class JBookController {

    @Autowired
    JBookRepository jBookRepository;

    @GetMapping("/jtest")
    public String test() {
        return "test jbook";
    }

    @GetMapping("/list")
    public Iterable<JBook> findAll() {
        Iterable<JBook> list = jBookRepository.findAll();
        return list;
    }

    @GetMapping("/abook/{id}")
    public Optional<JBook> findABook(@PathVariable Long id) {
        return jBookRepository.findById(id);
    }

    @GetMapping("/title/{title}")
    public List<JBook> findByTitle(@PathVariable String title) {
        return jBookRepository.findByTitle(title);
    }

//    @GetMapping("/page")
//    public Page<JBook> getPage(@PageableDefault(value = 3, sort = {"id"}, direction = Sort.Direction.DESC)Pageable pageable) {
//        return jBookRepository.findPage(pageable);
//    }

    @RestController
    public static class JwtController {


        @GetMapping("/jwtTest")
        public String test() {
            return "jwtTest";
        }
    }
}
