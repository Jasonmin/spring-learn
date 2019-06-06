package com.learnspring.jcc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JccController {

    @GetMapping("jcc")
    public String test() {
        return "test jcc";
    }
}
