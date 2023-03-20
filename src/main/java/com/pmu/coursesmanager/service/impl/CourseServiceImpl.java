package com.pmu.coursesmanager.service.impl;

import com.pmu.coursesmanager.dao.model.Course;
import com.pmu.coursesmanager.dao.model.Runner;
import com.pmu.coursesmanager.dao.model.dto.CourseDTO;
import com.pmu.coursesmanager.dao.repository.CourseRepository;
import com.pmu.coursesmanager.service.CourseService;
import com.pmu.coursesmanager.service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private RunnerService runnerService;
    @Override
    public Course addCourse(CourseDTO courseDTO) {
        Course course=new Course();
        course.setName(courseDTO.getName());
        course.setCreationDate(LocalDateTime.now());
        return this.courseRepository.save(course);
    }

    @Override
    public List<Course> getCourses() {
        return this.courseRepository.findAll();
    }
}
