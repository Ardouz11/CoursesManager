package com.pmu.coursesmanager.controller;

import com.pmu.coursesmanager.dao.model.Course;
import com.pmu.coursesmanager.dao.model.Runner;
import com.pmu.coursesmanager.dao.model.dto.CourseDTO;
import com.pmu.coursesmanager.service.CourseService;
import com.pmu.coursesmanager.service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course addCourse(@RequestBody @Valid CourseDTO courseDTO){
        return this.courseService.addCourse(courseDTO);
    }
    @GetMapping
    public List<Course> getCourses(){
        return this.courseService.getCourses();
    }

}
