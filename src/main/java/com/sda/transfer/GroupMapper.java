package com.sda.transfer;

import com.sda.dto.GroupDTO;
import com.sda.entities.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper {

    public GroupDTO convertGroupToGroupDTO(Group group) { // dam la paramentru doar obiectul de unde luam informatia
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName(group.getName());
        return groupDTO;
    }

    public Group convertGroupDTOtoGroup(GroupDTO groupDTO){
        Group group = new Group();
        group.setName(groupDTO.getName());
        return group;
    }
}
