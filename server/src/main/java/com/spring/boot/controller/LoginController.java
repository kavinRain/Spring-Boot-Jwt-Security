package com.spring.boot.controller;

import com.spring.boot.service.AuthService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("LoginController.Api")
public class LoginController {


    @Autowired
    private AuthService authService;

    @ApiOperation("登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", dataType = "String", required = true, value =
                    "登录名"),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value =
                    "密码")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @PostMapping("/auth/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        authService.login(username,password);
        return "登录成功!";
    }
}
