package com.sda.entities;

import javax.persistence.*;

/**
 * Created by Ionel Radu on 10/8/2019
 */

@Entity
@Table(name = "locker")
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "number")
    private Integer number;

    @OneToOne(mappedBy = "locker") // locker este obiectul
    private Student student;

    public Locker() {
    }

    public Locker(Integer number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean equals(Locker lockerToCompare) {
        if (this.number.equals(lockerToCompare.getNumber())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.number;
    }

    @Override
    public String toString() {
        return "Locker{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }

}
