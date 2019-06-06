package com.jdbc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class jwtController {

    @GetMapping("jwt")
    public String test() {
        return "test jwt";
    }
}
