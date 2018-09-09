package org.yqj.aop.demo.service.impl;

import org.springframework.stereotype.Service;
import org.yqj.aop.demo.service.TeacherService;

/**
 * @author yaoqijun on 2018-04-08.
 */
@Service
public class TeacherServiceImpl implements TeacherService{

    public String gainTeacherName(){
        return "teacherName";
    }

}
