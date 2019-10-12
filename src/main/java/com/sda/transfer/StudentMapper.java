package com.sda.transfer;

import com.sda.dto.StudentDTO;
import com.sda.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    /*public StudentDTO convertStudentToStudentDTO(Student student, StudentDTO studentDTO){
        studentDTO.setName(student.getNameStudent());
        studentDTO.setAge(student.getAge());
        studentDTO.setAverage_grade(student.getAverage_grade());

        return studentDTO;
    }*/
    // sau asa
    public StudentDTO convertStudentToStudentDTO(Student student) { // dam la paramentru doar obiectul de unde luam informatia
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(student.getNameStudent());
        studentDTO.setAge(student.getAge());
        studentDTO.setAverage_grade(student.getAverage_grade());

        return studentDTO;
    }

    public Student convertStudentDTOtoStudent(StudentDTO studentDTO){
        Student student = new Student();
        student.setNameStudent(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setAverage_grade(studentDTO.getAverage_grade());
        return student;
    }
}
