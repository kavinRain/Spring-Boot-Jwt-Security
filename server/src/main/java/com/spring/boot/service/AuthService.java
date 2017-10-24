package com.spring.boot.service;

import com.google.common.collect.Maps;
import com.spring.boot.util.JwtTokenUtil;
import com.spring.boot.vo.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    public Map<String, Object> login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        JwtUser jwtUser = (JwtUser)authentication.getPrincipal();
        final String token = jwtTokenUtil.generateToken(jwtUser);
        Map<String,Object> result = Maps.newHashMap();
        result.put("token",token);
        result.put("user",jwtUser);
        return result;
    }
}
