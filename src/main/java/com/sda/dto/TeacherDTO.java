package com.sda.dto;

public class TeacherDTO {

    private String name;
    private String discipline;
    public Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Teacher: " + name + " are varsta " + age + " si diciplina " + discipline ;
    }
}
