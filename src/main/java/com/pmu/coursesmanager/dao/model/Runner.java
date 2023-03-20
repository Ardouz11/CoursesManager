package com.pmu.coursesmanager.dao.model;

import com.pmu.coursesmanager.dao.model.Course;

import javax.persistence.*;

@Entity(name = "Runners")
public class Runner {
    @Id
    @GeneratedValue
    private Long number;
    @Column
    private String name;
    @ManyToOne
    private Course course;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
