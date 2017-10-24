package com.spring.boot.service;

import com.spring.boot.config.JwtUserFactory;
import com.spring.boot.entity.SysUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl extends BaseService<SysUser> implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = mapper.selectOne(new SysUser(username));
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            buildUserResources(user);
            return JwtUserFactory.create(user);
        }
    }

    private void buildUserResources(SysUser user) {

    }
}
