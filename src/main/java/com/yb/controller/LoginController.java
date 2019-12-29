package com.yb.controller;

import com.yb.pojo.User;
import com.yb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Yangbin
 * @date 2019/12/19 -16:02
 */

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/toRegister")
    public String toRegister() {
        return "register";
    }


    @RequestMapping(value = "register")
    @ResponseBody
    public String registerUser(String name, String pwd) {
        String msg = "";
        if (userService.addUser(new User(name, pwd))) {
            msg = "注册成功！";
        } else {
            msg = "注册失败！";
        }
        return msg;
    }
}
