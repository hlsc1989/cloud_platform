package com.m2.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.m2.dao.StudentMapper;
import com.m2.entity.Student;
import com.m2.service.feign.ServiceBClient;
import com.m2.service.feign.ServiceCClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentService {

    public static AtomicInteger atomicInteger = new AtomicInteger();

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ServiceBClient serviceBClient;
    @Autowired
    private ServiceCClient serviceCClient;

    @LcnTransaction
    @Transactional
    public String saveStudent() throws Exception {

        String sclass = serviceBClient.saveStudentClass();
        String resutl1 = serviceCClient.saveTeacher();
        if (!"ok".equals(resutl1)) {
            throw new Exception("错误了");
        }

        Student student = studentMapper.selectLastOne();
        if (student != null) {
            String index = student.getName().substring(student.getName().length() - 1, student.getName().length());
            atomicInteger = new AtomicInteger(Integer.parseInt(index));
        }

        Student s = new Student();
        int i = atomicInteger.incrementAndGet();
        s.setName("student" + i);
        s.setAddress("address" + i);
        s.setAge(i);
        s.setStudentClass(Integer.valueOf(sclass));

        studentMapper.insertSelective(s);
        return "ok";
    }
}
