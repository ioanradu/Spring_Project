package com.sda.service;

import com.sda.dao.LockerDao;
import com.sda.entities.Locker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ionel Radu on 10/8/2019
 */

@Service
public class LockerService {

    private LockerDao lockerDao;

    public LockerDao getLockerDao() {
        return lockerDao;
    }

    @Autowired
    public void setLockerDao(LockerDao lockerDao) {
        this.lockerDao = lockerDao;
    }

    public void addLocker(Locker locker) {
        getLockerDao().addLocker(locker);
    }

    public List<Locker> getLockerFromDao() {
        List<Locker> lockerList = lockerDao.getLockerList();
        return lockerList;
    }

    public boolean deleteLocker(Integer id) {
        return getLockerDao().deleteLockerDao(id);
    }

    public boolean updateLockerfromLockerDao(Integer id, Integer number) {
        return getLockerDao().editLocker(id, number);
    }

}
