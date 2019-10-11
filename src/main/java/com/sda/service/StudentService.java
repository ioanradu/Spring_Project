package com.sda.service;

import com.sda.dao.StudentDao;
import com.sda.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentDao studentDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    /*public Student findById(Integer id) {
        return getStudentDao().getEntityById(Student.class, id);
    }*/

    public void addStudent(Student student) {
        getStudentDao().addStudent(student);
    }

    public List<Student> getStudentsListFromDao() {
        List<Student> studentsList = getStudentDao().getStudentsList();
        return studentsList;
    }

    public boolean deleteStudent(Integer id) {
        return getStudentDao().deleteStudentDao(id);
    }

    public boolean updateStudentfromStudentDao(Integer id, Integer average_grade) {
        return getStudentDao().editStudent(id, average_grade);
    }

    public List<Student> getStudentListGraterThenFiveFromDao() {
        List<Student> studentsListGraterThanFive = getStudentDao().getStudentsListGraterThanFiveDao();
        return studentsListGraterThanFive;
    }
}
