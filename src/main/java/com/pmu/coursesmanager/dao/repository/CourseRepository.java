package com.pmu.coursesmanager.dao.repository;

import com.pmu.coursesmanager.dao.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
