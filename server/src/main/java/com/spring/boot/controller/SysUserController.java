package com.spring.boot.controller;

import com.spring.boot.entity.SysUser;
import com.spring.boot.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/user")
@Api("SysUserController.Api")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("查询所有的用户")
    @PostMapping("queryUserList")
    @PreAuthorize("hasRole('/sys/user/queryUserList')")
    List<SysUser> queryUserList() {
        return sysUserService.queryUserList();
    }


    @ApiOperation("添加用户")
    @PostMapping("addUser")
    @PreAuthorize("hasRole('/sys/user/addUser')")
    List<SysUser> addUser() {
        return sysUserService.queryUserList();
    }
}
