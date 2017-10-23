package com.spring.boot.service;

import com.spring.boot.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;

class BaseService<T> {

    @Autowired
    CommonMapper<T> mapper;

}
