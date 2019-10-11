package com.sda.service;

import com.sda.dao.GroupDao;
import com.sda.entities.Group;
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
    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public void addGroup(Group group) {
        getGroupDao().addGroup(group);
    }

    public List<Group> getGroupFromDao() {
        List<Group> lockerList = groupDao.getLockerList();
        return lockerList;
    }

    public boolean deleteGroup(Integer id) {
        return getGroupDao().deleteGroupDao(id);
    }

    public boolean updateGroupFromGroupDao(Integer id, String name) {
        return getGroupDao().editGroup(id, name);
    }
}
