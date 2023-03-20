package com.pmu.coursesmanager.service.impl;

import com.pmu.coursesmanager.dao.model.Course;
import com.pmu.coursesmanager.dao.model.Runner;
import com.pmu.coursesmanager.dao.repository.RunnerRepository;
import com.pmu.coursesmanager.service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RunnerServiceImpl implements RunnerService {

    @Autowired
    private RunnerRepository runnerRepository;
    @Override
    public List<Runner> addRunners(List<Runner> runners, Long courseNumber) {
        Course course=new Course();
        course.setNumber(courseNumber);
        for(Runner runner : runners){
            runner.setCourse(course);
        }
        return this.runnerRepository.saveAll(runners);
    }
    @Override
    public List<Runner> getRunners(Long courseNumber){
        return courseNumber==null? this.runnerRepository.findAll():this.runnerRepository.findByCourseNumber(courseNumber);
    }
}
