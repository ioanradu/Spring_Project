package com.sda.service;

import com.sda.dao.TeacherDao;
import com.sda.dto.TeacherDTO;
import com.sda.entities.Teacher;
import com.sda.transfer.TeacherMapper;
import com.sda.validator.TeacherValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    private TeacherDao teacherDao;
    //TeacherMapper teacherMapper = new TeacherMapper();

    public TeacherDao getTeacherDao() {
        return teacherDao;
    }

    @Autowired
    private TeacherValidator teacherValidator;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public void addTeacher(TeacherDTO teacherDTO) {
        if (teacherValidator.isTeacherDTOValid(teacherDTO)) { // se face validarea datelor introduse de la tastatura
            Teacher teacher = teacherMapper.convertTeacherDTOtoTeacher(teacherDTO);
            getTeacherDao().addteacher(teacher);
        } else {
            System.out.println("Valorile introduse nu indeplinesc cerintele cerute");
        }
    }

    public List<TeacherDTO> getTeacherListFromDao() {
        List<Teacher> teacherList = teacherDao.getTeacherList();
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            if (teacherValidator.isDisciplineNull(teacher)) {
                teacher.setDiscipline("---");
            }
            teacherDTOList.add(teacherMapper.convertTeacherToSTeacherDTO(teacher));
        }
        return teacherDTOList;
    }

    public boolean deleteTeacher(Integer id) {
        return teacherDao.deleteTeacherDao(id);
    }

    public boolean updateTeacherfromTeacherDao(Integer id, String name, Integer age, String discipline) {
        return teacherDao.editTeacher(id, name, age, discipline);
    }
}
