package com.sda.service;

import com.sda.dao.StudentDao;
import com.sda.dto.StudentDTO;
import com.sda.entities.Student;
import com.sda.transfer.StudentMapper;
import com.sda.validator.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private StudentDao studentDao;
    //StudentMapper studentMapper = new StudentMapper();

    public StudentDao getStudentDao() {
        return studentDao;
    }

    @Autowired
    private StudentValidator studentValidator;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void addStudent(StudentDTO studentDTO) {
        if(studentValidator.isDTOValid(studentDTO)){ // se face validarea datelor introduse de la tastatura
            Student student  = studentMapper.convertStudentDTOtoStudent(studentDTO);
            getStudentDao().addStudent(student);
        } else {
            System.out.println("Valorile introduse nu indeplinesc cerintele cerute");
        }

    }


    public List<StudentDTO> getStudentsListFromDao() {
        List<Student> studentsList = getStudentDao().getStudentsList();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for(Student student : studentsList){
            studentDTOList.add(studentMapper.convertStudentToStudentDTO(student));
        }
        return studentDTOList;
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
