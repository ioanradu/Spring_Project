package com.sda;

import com.sda.entryPoints.EntryPoints;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DependencyConfig.class);
        EntryPoints entryPoints = applicationContext.getBean(EntryPoints.class);
        //entryPoints.addStudent();
        //entryPoints.deleteStudentById(11);
        //entryPoints.updateStudent(5, 2);
        //entryPoints.displayStudents();

        //entryPoints.addTeacher();
        //entryPoints.deleteTeacherById(7);
        //entryPoints.updateTeacher(5, "Paul Gradinaru", 24, "Istorie");`
        //entryPoints.displayTeachers();

        //entryPoints.deleteLockerById(10);
        //entryPoints.addLocker();
        //entryPoints.updateLocker(15,15);
        //entryPoints.displayLockers();

        //entryPoints.updateGroup(5, "e");
        //entryPoints.deleteGroupById(6);
        //entryPoints.addGroup();
        //entryPoints.displayGroups();

        entryPoints.displayStudentsWithGradesGraterThenFive();
    }
}
