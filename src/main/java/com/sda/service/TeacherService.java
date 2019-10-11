package com.sda.service;

import com.sda.dao.TeacherDao;
import com.sda.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private TeacherDao teacherDao;

    public TeacherDao getTeacherDao() {
        return teacherDao;
    }

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public void addTeacher(Teacher teacher) {
        getTeacherDao().addteacher(teacher);
    }

    public List<Teacher> getTeacherListFromDao() {
        List<Teacher> teacherList = teacherDao.getTeacherList();
        return teacherList;
    }

    public boolean deleteTeacher(Integer id) {
        return teacherDao.deleteTeacherDao(id);
    }

    public boolean updateTeacherfromTeacherDao(Integer id, String name, Integer age, String discipline) {
        return teacherDao.editTeacher(id, name, age, discipline);
    }
}
