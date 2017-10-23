package com.spring.boot.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("login")
    String login(@RequestParam String username, @RequestParam String password) {
        if (!username.equals("admin")) {
            return "登录名称错误!";
        }
        if (!password.equals("123456")) {
            return "密码错误!";
        }
        return "登录成功!";
    }
}
