package com.sda.validator;

import com.sda.dto.TeacherDTO;
import com.sda.entities.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherValidator {

    public boolean isNameValid(String name){
        if(name == null){
            return false;
        }
        if(name.isEmpty()){
            return false;
        }
        if(!name.matches("([A-Z a-z])*")){
            return false;
        }
        return true;
    }

    public boolean isDisciplineValid(String disciplina){
        if(disciplina == null){
            return false;
        }
        if(disciplina.isEmpty()){
            return false;
        }
        if(!disciplina.matches("([A-Z a-z])*")){
            return false;
        }
        return true;
    }

    public boolean isAgeValid(Integer age){
        if(age == null){
            return false;
        }

        if(age < 18  || age > 100){
            return false;
        }
        return true;
    }

    public boolean isTeacherDTOValid(TeacherDTO teacherDTO){
        if(isNameValid(teacherDTO.getName()) && isDisciplineValid(teacherDTO.getDiscipline()) && isAgeValid(teacherDTO.getAge())){
            return true;
        }
        return false;
    }

    public boolean isDisciplineNull(Teacher teacher){
        if(teacher.getDiscipline() == null || teacher.getDiscipline().isEmpty()){
            return true;
        }
        return false;
    }
}
