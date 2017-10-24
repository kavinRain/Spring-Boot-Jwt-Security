package com.spring.boot.controller;

import com.spring.boot.service.AuthService;
import com.spring.boot.vo.ResponseVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@Api("LoginController.Api")
public class LoginController {


    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

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
    public ResponseVo<Map<String, Object>> login(@RequestParam String username, @RequestParam String password,
                                                 HttpServletResponse response) {
        Map<String, Object> result = authService.login(username, password);
        return new ResponseVo<>(10000, "登录成功!", result);
    }
}
