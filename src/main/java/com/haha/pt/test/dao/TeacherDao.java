package com.haha.pt.test.dao;


import com.haha.pt.test.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherDao {
    List<Teacher> queryAll();

}
