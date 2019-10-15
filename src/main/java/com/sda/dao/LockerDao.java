package com.sda.dao;

import com.sda.entities.Locker;

import com.sda.entities.Student;
import com.sda.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ionel Radu on 10/8/2019
 */
@Repository
public class LockerDao extends GenericDao {

    public void addLocker(Locker locker) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(locker);
            System.out.println("Locker was created with id: " + id);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public List<Locker> getLockerList() {
        List<Locker> lockerList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            String sql = "from Locker";
            Query query = session.createQuery(sql);
            lockerList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lockerList;
    }

    public boolean deleteLockerDao(Integer id) {
        boolean validator = false;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Locker locker = session.get(Locker.class, id);
            if (locker != null) {
                Student student = session.get(Student.class, id);
                student.setLocker(null);
                session.beginTransaction();
                session.update(student);
                session.delete(locker);
                session.getTransaction().commit();
                validator = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validator;
    }

    public boolean editLocker(Integer id, Integer number) {
        boolean validator = false;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Locker locker = session.get(Locker.class, id);
            if (locker != null) {
                String sql = "UPDATE Locker SET number=:number WHERE id = :id";
                Query query = session.createQuery(sql);
                query.setParameter("number", number);
                query.setParameter("id", id);
                Integer querySucces = query.executeUpdate();
                session.getTransaction().commit();

                if (querySucces != 0) {
                    validator = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validator;
    }
}
