package com.learnspring.jcc;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class JUserController {

    @Autowired
    TokenService tokenService;

    @GetMapping("/jtest")
    public String test() {
        return "api.test";
    }

    //登录
    @GetMapping("/login/{userName}")
//    public List findByTitle(@PathVariable String bookTitle) {
//        return bookRepository.findByTitle(bookTitle);
//    }
    public Object login(@PathVariable String userName){
        JUser user = new JUser();
        user.username = userName;

        String token = tokenService.getToken(user);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("token",token);
        jsonObject.put("status",true);

        return jsonObject;
    }

    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
