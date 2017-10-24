package com.spring.boot;

import com.spring.boot.entity.SysUser;
import com.spring.boot.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/9/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void updateUserByUserName() {
        SysUser user = sysUserMapper.selectOne(new SysUser("SysUser_pakfsv"));
        user.setPassword(new BCryptPasswordEncoder().encode("SysUser_pakfsv"));
        sysUserMapper.updateByPrimaryKeySelective(user);
    }

}
