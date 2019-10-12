package com.sda.validator;

import com.sda.dto.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentValidator {

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

    public boolean isAgeValid(Integer age){
        if(age == null){
            return false;
        }

        if(age < 18  || age > 100){
            return false;
        }
        return true;
    }

    public boolean isAverageGradeValid(Integer average_grade){
        if(average_grade == null){
            return false;
        }

        if(average_grade < 1 || average_grade > 10){
            return false;
        }
        return true;
    }

    public boolean isDTOValid(StudentDTO studentDTO){
        if(isNameValid(studentDTO.getName()) && isAgeValid(studentDTO.getAge()) && isAverageGradeValid(studentDTO.getAverage_grade())){
            return true;
        }
        return false;
    }
}
