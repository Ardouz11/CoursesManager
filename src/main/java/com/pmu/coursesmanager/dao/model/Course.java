package com.pmu.coursesmanager.dao.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Courses")
public class Course {
    @Id
    @GeneratedValue
    private Long number;
    @Column(unique = true)
    private String name;
    @Column
    private LocalDateTime creationDate;

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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
