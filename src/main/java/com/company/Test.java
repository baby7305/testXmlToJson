package com.company;

import com.company.config.HmacSHA256Utils;

import java.util.HashMap;
import java.util.Map;


public class Test {
    public static void main(String[] args) {
        //实际中，此代码是由客户端进行编写.
        String key = "andy123456";
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", "admin");
        map.put("params1", "love");
        map.put("params2", "girl");
        System.out.println(HmacSHA256Utils.digest(key, map));
    }
}
