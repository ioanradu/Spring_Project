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
        boolean validator = false;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student = session.get(Student.class, id);
            if (student != null) {
               student.setAverage_grade(average_grade);
               session.beginTransaction();
               session.update(student);
               session.getTransaction().commit();
               validator = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return validator;
    }

    public boolean deleteStudentDao(Integer id) {
        boolean validator = false;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.beginTransaction();
                session.delete(student);
                session.getTransaction().commit();
                validator = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validator;
    }

    public List<Student> getStudentsList() {
        List<Student> studentsList = new ArrayList<>();
        try( Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "from Student";
            session.beginTransaction();
            Query query = session.createQuery(hql);
            studentsList = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsList;
    }


    public List<Student> getStudentsListGraterThanFiveDao() {
        List<Student> studentListGraterThanFive = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            String sql = "from Student where average_grade >= 5";
            Query query = session.createQuery(sql);
            studentListGraterThanFive = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentListGraterThanFive;
    }
}
