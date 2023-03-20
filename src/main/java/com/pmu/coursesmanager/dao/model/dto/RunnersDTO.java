package com.pmu.coursesmanager.dao.model.dto;

import com.pmu.coursesmanager.dao.model.Runner;

import javax.validation.constraints.Size;
import java.util.List;

public class RunnersDTO {
    @Size(min=3)
    List<Runner> runners;

    public List<Runner> getRunners() {
        return runners;
    }

    public void setRunners(List<Runner> runners) {
        this.runners = runners;
    }
}
