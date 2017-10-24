package com.spring.boot.entity;

import lombok.Data;

@Data
public class SysResource {
    private Integer id;

    private String resourceName;

    private String resourcePath;

    private Boolean enable;
}