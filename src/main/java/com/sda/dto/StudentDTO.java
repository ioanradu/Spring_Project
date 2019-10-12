package com.sda.dto;

public class StudentDTO {
    private String name;
    private Integer age;
    private Integer average_grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Studentul are urmatoarele date: " + "nume: " + name + ", varsta: " + age + ", si nota: " + average_grade;
    }
}
