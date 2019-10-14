package com.sda;

import com.sda.dto.GroupDTO;
import com.sda.dto.StudentDTO;
import com.sda.dto.TeacherDTO;
import com.sda.entryPoints.EntryPoints;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DependencyConfig.class);
        EntryPoints entryPoints = applicationContext.getBean(EntryPoints.class);

        //entryPoints.deleteStudentById(6);
        //entryPoints.updateStudent(4, 4);
        //entryPoints.displayStudents();

        //entryPoints.deleteTeacherById(7);
        //entryPoints.updateTeacher(5, "Paul Gradinaru", 24, "Istorie");`
        //entryPoints.displayTeachers();

        //entryPoints.deleteLockerById(3);
        //entryPoints.addLocker();
        //entryPoints.updateLocker(15,15);
        //entryPoints.displayLockers();

        //entryPoints.updateGroup(5, "e");
        //entryPoints.deleteGroupById(1);
        //entryPoints.addGroup();
        //entryPoints.displayGroups();

        //entryPoints.displayStudentsWithGradesGraterThenFive();

        Scanner scanner = new Scanner(System.in);

       /* System.out.println("Introduceti numele: ");
        String nume  = scanner.nextLine();

        System.out.println("Introduceti varsta: ");
        Integer age = scanner.nextInt();

        System.out.println("Media: ");
        Integer average = scanner.nextInt();

        System.out.println("Ati introdus urmatoarele date: " + nume + " "+ age + " " + average);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(nume);
        studentDTO.setAge(age);
        studentDTO.setAverage_grade(average);


        entryPoints.addStudent(studentDTO);*/

       /* System.out.println("Introduceti numele: ");
        String numeTeacher  = scanner.nextLine();

        System.out.println("Introduceti disciplina: ");
        String disciplina  = scanner.nextLine();

        System.out.println("Introduceti varsta: ");
        Integer ageTeacher = scanner.nextInt();

        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setName(numeTeacher);
        teacherDTO.setDiscipline(disciplina);
        teacherDTO.setAge(ageTeacher);

        entryPoints.addTeacher(teacherDTO);
*/
        System.out.println("Introduceti numele grupului: ");
        String groupName = scanner.nextLine();

        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName(groupName);

        entryPoints.addGroup(groupDTO);
    }
}
