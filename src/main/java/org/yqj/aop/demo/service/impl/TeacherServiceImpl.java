package org.yqj.aop.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.yqj.aop.demo.service.TeacherService;

/**
 * @author yaoqijun on 2018-04-08.
 */
@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService{

    @Override
    public String helloWorldName(String name) {
        log.info("************* hello world name function is running");
        return "hello world " + name;
    }

    @Override
    public String helloWorldWithException(String name) {
        throw new IllegalStateException("illegal state exception " + name);
    }
}
