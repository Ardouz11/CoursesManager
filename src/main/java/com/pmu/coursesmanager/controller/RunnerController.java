package com.pmu.coursesmanager.controller;

import com.pmu.coursesmanager.dao.model.Runner;
import com.pmu.coursesmanager.dao.model.dto.RunnersDTO;
import com.pmu.coursesmanager.service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/")
public class RunnerController {
    @Autowired
    private RunnerService runnerService;
    @PostMapping(value = "courses/{courseNumber}/runners")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Runner> addRunners(@RequestBody @Valid RunnersDTO runnersDTO, @PathVariable(value = "courseNumber") Long courseNumber){
        return this.runnerService.addRunners(runnersDTO.getRunners(),courseNumber);
    }
    @GetMapping(value="courses/{courseNumber}/runners")
    public List<Runner> getRunnersOfCourse(@PathVariable(value="courseNumber") Long courseNumber){
        return this.runnerService.getRunners(courseNumber);
    }
}
