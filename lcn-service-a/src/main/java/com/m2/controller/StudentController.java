package com.m2.controller;

import com.m2.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping("/saveStudent")
    public String saveStudent() throws Exception{
        long t1 = System.currentTimeMillis();
        String result = studentService.saveStudent();
        long t2 = System.currentTimeMillis();
        logger.info("==========================>" + (t2 - t1) + "ms");
        return result;
    }

}
