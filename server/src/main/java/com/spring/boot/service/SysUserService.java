package com.spring.boot.service;

import com.spring.boot.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService extends BaseService<SysUser> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<SysUser> queryUserList() {
        return mapper.selectAll();
    }
}
