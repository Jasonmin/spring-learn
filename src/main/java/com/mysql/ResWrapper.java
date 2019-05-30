package com.mysql;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Service
public class ResWrapper {

    public HashMap<String,Object>  wrapResultData(int res,Object data){

        HashMap<String,Object> map = new LinkedHashMap<>();

        map.put("code",res);
        String msg = "";
        if (res == 1) {
            msg = "成功";
        } else {
            msg = "失败";
        }
        map.put("msg",msg);
        map.put("data",data);

        return map;
    }
}
