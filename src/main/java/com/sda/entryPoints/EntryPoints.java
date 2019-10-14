package com.sda.entryPoints;

import com.sda.dto.GroupDTO;
import com.sda.dto.StudentDTO;
import com.sda.dto.TeacherDTO;
import com.sda.entities.Group;
import com.sda.entities.Locker;
import com.sda.entities.Student;
import com.sda.entities.Teacher;
import com.sda.service.GroupService;
import com.sda.service.LockerService;
import com.sda.service.StudentService;
import com.sda.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class EntryPoints {
    private StudentService studentService;
    private TeacherService teacherService;
    private LockerService lockerService;
    private GroupService groupService;

    public LockerService getLockerService() {
        return lockerService;
    }

    @Autowired
    public void setLockerService(LockerService lockerService) {
        this.lockerService = lockerService;
    }

    public GroupService getGroupService() {
        return groupService;
    }

    @Autowired
    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }


    public StudentService getStudentService() {
        return studentService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public TeacherService getTeacherService() {
        return teacherService;
    }

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public void displayStudents() {
        List<StudentDTO> studentsList = getStudentService().getStudentsListFromDao();
        for (StudentDTO student : studentsList) {
            System.out.println(student);
        }
    }

    public void addStudent(StudentDTO studentDTO) {
        getStudentService().addStudent(studentDTO);
        /*Student student = new Student();
        student.setNameStudent("Ana Maria");
        student.setAge(23);
        student.setAverage_grade(3);

        Locker locker = new Locker();
        locker.setNumber(13);
        student.setLocker(locker);
        getStudentService().addStudent(student);*/

    }

    public void deleteStudentById(Integer id) {
        if (getStudentService().deleteStudent(id)) {
            System.out.println("Studentul cu id-ul " + id + " a fost sters cu succes!");
        } else {
            System.out.println("Studentul cu id-ul " + id + " nu a fost gasit in baza de date");
        }
    }

    public void updateStudent(Integer id, Integer average_grade) {
        if (getStudentService().updateStudentfromStudentDao(id, average_grade)) {
            System.out.println("Studentul a fost modificat cu succes!");
        } else {
            System.out.println("Studentul nu a fost modificat cu succes!");
        }
    }

    public void displayTeachers() {
        List<TeacherDTO> teacherDTOList = getTeacherService().getTeacherListFromDao();
        for (TeacherDTO teacherDTO : teacherDTOList) {
            System.out.println(teacherDTO);
        }
    }

    public void addTeacher(TeacherDTO teacherDTO) {
        getTeacherService().addTeacher(teacherDTO);
        /*Teacher teacher = new Teacher();
        teacher.setName("Mariana Barghisan");
        teacher.setAge(57);
        teacher.setDiscipline("Matematica");
        getTeacherService().addTeacher(teacher);*/
    }

    public void deleteTeacherById(Integer id) {
        if (getTeacherService().deleteTeacher(id)) {
            System.out.println("Teacher cu id-ul " + id + " a fost sters cu succes!");
        } else {
            System.out.println("Teacher cu id-ul " + id + " nu a fost gasit in baza de date");
        }
    }

    public void updateTeacher(Integer id, String name, Integer age, String discipline) {
        if (getTeacherService().updateTeacherfromTeacherDao(id, name, age, discipline)) {
            System.out.println("Teacher a fost modificat cu succes!");
        } else {
            System.out.println("Teacher nu a fost modificat cu succes!");
        }
    }

    public void addLocker() {
        Locker locker = new Locker();
        locker.setNumber(100);
        getLockerService().addLocker(locker);
    }

    public void displayLockers() {
        List<Locker> lockerList = getLockerService().getLockerFromDao();
        for (Locker locker : lockerList) {
            System.out.println(locker);
        }
    }

    public void deleteLockerById(Integer id) {
        if (getLockerService().deleteLocker(id)) {
            System.out.println("Locker-ul cu id-ul " + id + " a fost sters cu succes!");
        } else {
            System.out.println("Locker-ul cu id-ul " + id + " nu a fost gasit in baza de date");
        }
    }

    public void updateLocker(Integer id, Integer number) {
        if (getLockerService().updateLockerfromLockerDao(id, number)) {
            System.out.println("Locker-ul a fost modificat cu succes!");
        } else {
            System.out.println("Locker-ul nu a fost modificat cu succes!");
        }
    }

    public void addGroup(GroupDTO groupDTO) {
        getGroupService().addGroup(groupDTO);
    }

    public void displayGroups() {
        List<Group> groupList = getGroupService().getGroupFromDao();
        for (Group group : groupList) {
            System.out.println(group);
        }
    }

    public void deleteGroupById(Integer id) {
        if (getGroupService().deleteGroup(id)) {
            System.out.println("Group-ul cu id-ul " + id + " a fost sters cu succes!");
        } else {
            System.out.println("Group-ul cu id-ul " + id + " nu a fost gasit in baza de date");
        }
    }

    public void updateGroup(Integer id, String name) {
        if (getGroupService().updateGroupFromGroupDao(id, name)) {
            System.out.println("Group-ul a fost modificat cu succes!");
        } else {
            System.out.println("Group-ul nu a fost modificat cu succes!");
        }
    }

    public void displayStudentsWithGradesGraterThenFive() {
        List<Student> studentListGraterThenFive = getStudentService().getStudentListGraterThenFiveFromDao();
        for (Student student : studentListGraterThenFive) {
            System.out.println(student);
        }
    }

}
