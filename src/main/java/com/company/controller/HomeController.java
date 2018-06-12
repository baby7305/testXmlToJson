package com.company.controller;

import com.company.core.bean.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/index"})
    public String index(Map<String, Object> map) {
        //获取到用户信息.Shiro.---SecurityUtils.getSubject() 获取到.UserInfo.
        Subject subject = SecurityUtils.getSubject();
        UserInfo userInfo = (UserInfo) subject.getPrincipal();
        map.put("userInfo", userInfo);
        return "/index";
    }

    //只能使用get方式进行请求. post:在点击登录的时候进行使用.
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(HttpServletRequest request, Map<String, Object> map) {

        //登录失败从request对象中可以获取shiro处理异常的细信息.
        //shiroLoginFailure.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                msg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                msg = "密码不正确";
            } else if (ExcessiveAttemptsException.class.getName().equals(exception)) {
                msg = "密码输入错误次数过多";
            } else {
                msg = "else -->" + exception;
            }
        }
        map.put("msg", msg);
        return "/login";
    }
}
