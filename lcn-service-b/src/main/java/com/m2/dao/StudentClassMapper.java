package com.m2.dao;

import com.m2.entity.StudentClass;

public interface StudentClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentClass record);

    int insertSelective(StudentClass record);

    StudentClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentClass record);

    int updateByPrimaryKey(StudentClass record);

    StudentClass selectLastOne();
}