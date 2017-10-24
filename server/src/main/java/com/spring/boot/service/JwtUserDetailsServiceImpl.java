package com.spring.boot.service;

import com.google.common.collect.Lists;
import com.spring.boot.config.JwtUserFactory;
import com.spring.boot.entity.SysResource;
import com.spring.boot.entity.SysRoleResource;
import com.spring.boot.entity.SysUser;
import com.spring.boot.entity.SysUserRole;
import com.spring.boot.mapper.SysResourceMapper;
import com.spring.boot.mapper.SysRoleResourceMapper;
import com.spring.boot.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtUserDetailsServiceImpl extends BaseService<SysUser> implements UserDetailsService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysRoleResourceMapper sysRoleResourceMapper;

    @Autowired
    private SysResourceMapper sysResourceMapper;

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
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.select(new SysUserRole(user.getId()));
        List<SysRoleResource> sysRoleResources = sysRoleResourceMapper.selectAll();
        List<SysResource> sysResources = sysResourceMapper.selectAll();
        List<String> resources = Lists.newArrayList();
        sysUserRoles.forEach(sysUserRole -> sysRoleResources.forEach(sysRoleResource -> sysResources.forEach(sysResource -> {
            if (sysRoleResource.getRoleId().equals(sysUserRole.getRoleId()) && sysResource.getId().equals
                    (sysRoleResource.getResourceId()) && !resources.contains(sysResource.getResourcePath())) {
                resources.add(String.format("ROLE_%s", sysResource.getResourcePath()));
            }
        })));
        user.setResources(resources);
    }
}
