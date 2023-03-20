package com.pmu.coursesmanager.service;

import com.pmu.coursesmanager.dao.model.Runner;

import java.util.List;

public interface RunnerService {
    List<Runner> addRunners(List<Runner> runners, Long courseNumber);
    List<Runner> getRunners(Long courseNumber);
}
