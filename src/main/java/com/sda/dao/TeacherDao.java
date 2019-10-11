package com.sda.dao;

import com.sda.entities.Teacher;
import com.sda.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherDao extends GenericDao {

    public void addteacher(Teacher teacher) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(teacher);
            System.out.println("Teacher was created with id: " + id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public List<Teacher> getTeacherList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Teacher> teacherList = new ArrayList<>();
        try {
            String sql = "FROM Teacher";
            Query query = session.createQuery(sql, Teacher.class);
            teacherList = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        transaction.commit();
        session.close();
        return teacherList;
    }

    public boolean deleteTeacherDao(Integer id) {
        boolean validator = false;
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            session.beginTransaction();
            Teacher teacher = session.get(Teacher.class, id);
            if (teacher != null) {
                session.delete(teacher);
                session.getTransaction().commit();
                validator = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return validator;
    }

    public boolean editTeacher(Integer id, String name, Integer age, String discipline) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        boolean validator = false;
        try {
            Teacher teacher = session.get(Teacher.class, id);
            if (teacher != null) {
                String sql = "UPDATE Teacher SET name=:name, age=:age, discipline=:discipline WHERE id = :id";
                Query query = session.createQuery(sql);
                query.setParameter("name", name);
                query.setParameter("age", age);
                query.setParameter("discipline", discipline);
                query.setParameter("id", id);
                Integer querrySucces = query.executeUpdate();

                if (querrySucces != 0) {
                    validator = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        transaction.commit();
        session.close();
        return validator;
    }
}
