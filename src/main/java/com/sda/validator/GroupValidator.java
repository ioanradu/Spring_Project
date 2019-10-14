package com.sda.validator;

import com.sda.dto.GroupDTO;
import com.sda.entities.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupValidator {

    public boolean isGroupNameValid(GroupDTO groupDTO){
        if(groupDTO.getName() == null || groupDTO.getName().isEmpty()){
            return false;
        }
        return true;
    }
}
