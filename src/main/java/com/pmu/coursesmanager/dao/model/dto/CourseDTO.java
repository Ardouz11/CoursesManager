package com.pmu.coursesmanager.dao.model.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CourseDTO {

    @NotBlank
    @NotEmpty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
