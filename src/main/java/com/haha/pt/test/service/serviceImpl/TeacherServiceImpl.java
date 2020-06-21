package com.haha.pt.test.service.serviceImpl;

import com.haha.pt.test.dao.TeacherDao;
import com.haha.pt.test.entity.Teacher;
import com.haha.pt.test.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> queryAll() {

        return teacherDao.queryAll();
    }
}
