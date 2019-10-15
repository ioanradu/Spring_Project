package com.sda.service;

import com.sda.dao.GroupDao;
import com.sda.dto.GroupDTO;
import com.sda.entities.Group;
import com.sda.transfer.GroupMapper;
import com.sda.validator.GroupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ionel Radu on 10/11/2019
 */
@Service
public class GroupService {
    private GroupDao groupDao;

    public GroupDao getGroupDao() {
        return groupDao;
    }

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    public GroupValidator groupValidator;

    @Autowired
    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public void addGroup(GroupDTO groupDTO) {
        Group group = new Group();
        if(groupValidator.isGroupNameValid(groupDTO)){
            group = groupMapper.convertGroupDTOtoGroup(groupDTO);
        }else {
            System.out.println("Valorile introduse nu indeplinesc cerintele cerute");
        }
        getGroupDao().addGroup(group);
    }

    public List<Group> getGroupFromDao() {
        List<Group> groupList = groupDao.getGroupList();
        return groupList;
    }

    public boolean deleteGroup(Integer id) {
        return getGroupDao().deleteGroupDao(id);
    }

    public boolean updateGroupFromGroupDao(Integer id, String name) {
        return getGroupDao().editGroup(id, name);
    }
}
