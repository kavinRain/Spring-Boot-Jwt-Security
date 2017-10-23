package com.spring.boot.entity;

import lombok.Data;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class SysUser implements Serializable {

    private Long id;

    private String username;

    private String password;

    private String email;

    private Date lastPasswordResetDate;

    @Transient
    private List<String> resources;


    public SysUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SysUser(String username) {
        this.username = username;
    }

    public SysUser() {
    }
}