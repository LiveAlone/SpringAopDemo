package org.yqj.aop.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yqj.aop.demo.service.TeacherService;

/**
 * Created by yaoqijun.
 * Date:2016-04-27
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
@Component
@Slf4j
public class RunCommandLine implements CommandLineRunner{

    @Autowired
    private TeacherService teacherService;

    public void run(String... args) throws Exception {
        log.info("teacher service get teacher name :{}", teacherService.gainTeacherName());
    }
}
