package com.sda.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Stack;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_student")
    private String nameStudent;

    @Column(name = "age")
    private Integer age;

    @Column(name = "average_grade")
    private Integer average_grade;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "locker_id") // foreign key
    private Locker locker;

    @ManyToOne
    @JoinTable(name = "students_groupss", joinColumns = {@JoinColumn(name = "students_id")}, //aici e declarat tabelul de legatura
            inverseJoinColumns = {@JoinColumn(name = "groupss_id")})
    private Group group;

    @ManyToMany(mappedBy = "students_list")
    private List<Teacher> teacherList;

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String name) {
        this.nameStudent = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAverage_grade() {
        return average_grade;
    }

    public void setAverage_grade(Integer average_grade) {
        this.average_grade = average_grade;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public Locker integerToLocker(int locker_id) {
        Locker number = new Locker(locker_id);
        Stack<Locker> myStack = new Stack();
        myStack.push(number);
        number = myStack.pop();
        return number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + nameStudent + '\'' +
                ", age=" + age +
                ", average_grade=" + average_grade +
                ", locker=" + locker +
                '}';
    }
}
