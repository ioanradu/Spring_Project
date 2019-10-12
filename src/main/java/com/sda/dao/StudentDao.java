package com.sda.dao;

import com.sda.entities.Student;
import com.sda.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao extends GenericDao {

    public void addStudent(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(student);
            System.out.println("Student was created with id: " + id);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public boolean editStudent(Integer id, Integer average_grade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        boolean validator = false;
        try {
            Student student = session.get(Student.class, id);
            if (student != null) {
                String sql = "UPDATE Student SET average_grade=:average_grade WHERE id = :id";
                Query query = session.createQuery(sql);
                query.setParameter("average_grade", average_grade);
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

    public boolean deleteStudentDao(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        boolean validator = false;
        try {
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
                validator = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        transaction.commit();
        session.close();
        return validator;
    }

    public List<Student> getStudentsList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> studentsList = new ArrayList<>();
        try {
            String hql = "from Student";

            Query query = session.createQuery(hql);
            studentsList = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        transaction.commit();
        session.close();
        return studentsList;
    }


    public List<Student> getStudentsListGraterThanFiveDao() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> studentListGraterThanFive = new ArrayList<>();
        try {
            String sql = "from Student where average_grade >= 5";
            Query query = session.createQuery(sql);
            studentListGraterThanFive = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        transaction.commit();
        session.close();
        return studentListGraterThanFive;
    }
}
