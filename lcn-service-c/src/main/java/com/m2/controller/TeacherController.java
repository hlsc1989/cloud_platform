package com.m2.controller;

import com.m2.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/saveTeacher")
    public String saveTeacher() {
        return teacherService.saveTeacher();
    }

}
