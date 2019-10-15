package com.sda.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ionel Radu on 10/10/2019
 */

@Entity
@Table(name = "groupss")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "group")
    @ElementCollection(targetClass = Student.class)
    private List<Student> students;

    public Group() {
    }

    public Group(List<Student> students) {
        this.students = students;
    }

    public Group(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Group groupToCompare) {
        if (this.name.equals(groupToCompare.getName()) &&
                this.id == groupToCompare.id) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.name.length() + this.id;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}