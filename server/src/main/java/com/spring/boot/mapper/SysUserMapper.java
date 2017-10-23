package com.spring.boot.mapper;

import com.spring.boot.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends CommonMapper<SysUser> {

}