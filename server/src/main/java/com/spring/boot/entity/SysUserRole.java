package com.spring.boot.entity;

import lombok.Data;

@Data
public class SysUserRole {
    private Long id;

    private Long userId;

    private Integer roleId;
}