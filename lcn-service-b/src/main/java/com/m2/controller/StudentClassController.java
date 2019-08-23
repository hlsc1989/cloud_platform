package com.m2.controller;

import com.m2.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentClassController {

    @Autowired
    private StudentClassService studentClassService;

    @RequestMapping("/saveStudentClass")
    public String saveStudentClass() {
        return studentClassService.saveStudentClass();
    }

}
