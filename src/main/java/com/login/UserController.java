package com.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> login(@RequestParam(value = "userName") String userName,
                                    @RequestParam(value = "password") String password) {
        Map<String ,Object> map = new HashMap<>();
        User target = userService.verifyLogin(userName, password);

        boolean success = target != null;

        map.put("data",target);
        map.put("msg",success?"success":"fail");
        map.put("code",success?1:0);

        return map;
    }

}
