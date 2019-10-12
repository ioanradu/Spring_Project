package com.sda.transfer;

import com.sda.dto.TeacherDTO;
import com.sda.entities.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    public TeacherDTO convertTeacherToSTeacherDTO(Teacher teacher) { // dam la paramentru doar obiectul de unde luam informatia
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setName(teacher.getName());
        teacherDTO.setAge(teacher.getAge());
        teacherDTO.setDiscipline(teacher.getDiscipline());
        return teacherDTO;
    }

    public Teacher convertTeacherDTOtoTeacher(TeacherDTO teacherDTO){
        Teacher teacher = new Teacher();
        teacher.setName(teacherDTO.getName());
        teacher.setDiscipline(teacherDTO.getDiscipline());
        teacher.setAge(teacherDTO.getAge());
        return teacher;
    }
}
