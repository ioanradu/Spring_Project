package com.sda.dao;

import com.sda.entities.Group;
import com.sda.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ionel Radu on 10/10/2019
 */

@Repository
public class GroupDao {

    public void addGroup(Group group) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(group);
            System.out.println("Group was created with id: " + id);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public List<Group> getGroupList() {
        List<Group> groupList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            String sql = "from Group";
            Query query = session.createQuery(sql);
            groupList = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groupList;
    }

    public boolean deleteGroupDao(Integer id) {
        boolean validator = false;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Group group = session.get(Group.class, id);
            if (group != null) {
                session.delete(group);
                session.getTransaction().commit();
                validator = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validator;
    }

    public boolean editGroup(Integer id, String name) {
        boolean validator = false;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Group group = session.get(Group.class, id);
            if (group != null) {
                session.beginTransaction();
                group.setName(name);
                session.update(group);
                session.getTransaction().commit();
                validator = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validator;
    }
}
