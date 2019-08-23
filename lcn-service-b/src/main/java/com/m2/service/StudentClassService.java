package com.m2.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.m2.dao.StudentClassMapper;
import com.m2.entity.StudentClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentClassService {

    public static AtomicInteger atomicInteger = new AtomicInteger();

    @Autowired
    private StudentClassMapper studentClassMapper;

    @LcnTransaction
    @Transactional
    public String saveStudentClass() {
        StudentClass studentClass = studentClassMapper.selectLastOne();
        if (studentClass != null) {
            String index = studentClass.getName().substring(studentClass.getName().length() - 1, studentClass.getName().length());
            atomicInteger = new AtomicInteger(Integer.parseInt(index));
        }

        StudentClass sc = new StudentClass();
        sc.setName("年级" + atomicInteger.incrementAndGet());
        studentClassMapper.insertSelective(sc);
        return sc.getId().toString();
    }

}
