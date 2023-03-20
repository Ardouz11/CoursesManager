package com.pmu.coursesmanager.service;

import com.pmu.coursesmanager.dao.model.Course;
import com.pmu.coursesmanager.dao.model.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    Course addCourse(CourseDTO courseDTO);
    List<Course> getCourses();

}
