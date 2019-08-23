package com.m2.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.m2.dao.TeacherMapper;
import com.m2.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TeacherService {

    public static AtomicInteger atomicInteger = new AtomicInteger();

    @Autowired
    private TeacherMapper teacherMapper;

    @LcnTransaction
    @Transactional
    public String saveTeacher() {
        Teacher teacher = teacherMapper.selectLastOne();
        if (teacher != null) {
            String index = teacher.getName().substring(teacher.getName().length() - 1, teacher.getName().length());
            atomicInteger = new AtomicInteger(Integer.parseInt(index));
        }

        Teacher t = new Teacher();

        int i = atomicInteger.incrementAndGet();

        t.setName("teacher" + i);
        t.setAddress("address" + i);
        t.setAge(i);

        teacherMapper.insertSelective(t);

        return "ok";
    }

}
