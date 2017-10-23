package com.spring.boot.config;

import com.spring.boot.entity.SysUser;
import com.spring.boot.vo.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(SysUser user) {
        return new JwtUser(
                String.valueOf(user.getId()),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                mapToGrantedAuthorities(user.getResources()),
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}
