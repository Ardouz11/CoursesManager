package com.pmu.coursesmanager.dao.repository;

import com.pmu.coursesmanager.dao.model.Runner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RunnerRepository extends JpaRepository<Runner,Long> {
    List<Runner> findByCourseNumber(Long courseNumber);
}
