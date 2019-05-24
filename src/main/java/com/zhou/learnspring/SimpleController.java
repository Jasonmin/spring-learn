package com.zhou.learnspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleController {

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
