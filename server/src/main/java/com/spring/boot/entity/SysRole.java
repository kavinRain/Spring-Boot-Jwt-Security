package com.spring.boot.entity;

import lombok.Data;

@Data
public class SysRole {
    private Integer id;

    private String roleName;

    private Boolean enable;

}