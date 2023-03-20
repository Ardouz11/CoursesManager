package com.pmu.coursesmanager.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pmu.coursesmanager.dao.model.Course;
import com.pmu.coursesmanager.dao.model.Runner;
import com.pmu.coursesmanager.dao.repository.CourseRepository;
import com.pmu.coursesmanager.dao.repository.RunnerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import javax.transaction.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class RunnerServiceTest {

	@Autowired
	RunnerRepository runnerRepository;

	@Autowired
	RunnerService runnerService;
	@Autowired
	CourseRepository courseRepository;
	@Test
	public void shouldReturnCreatedRunners() {
		Course course =new Course();
		course.setName("Course Three");
		courseRepository.save(course);
		List<Runner> runners=new ArrayList<Runner>(3);
		Runner runnerOne=new Runner();
		Runner runnerTwo=new Runner();
		Runner runnerThree=new Runner();
		runnerOne.setName("Runner Four");
		runnerTwo.setName("Runner Five");
		runnerThree.setName("Runner Six");
		runnerOne.setCourse(course);
		runnerTwo.setCourse(course);
		runnerThree.setCourse(course);
		runners.add(runnerOne);
		runners.add(runnerTwo);
		runners.add(runnerThree);
	    runnerRepository.saveAll(runners);

		List<Runner> runnerList = runnerService.getRunners(course.getNumber());

		assertNotNull("runner list shouldn't be null", runnerList);
		assertThat(runnerList.get(0).getName(), equalTo("Runner Four"));
		assertThat(runnerList.get(0).getCourse().getNumber(), equalTo(course.getNumber()));
	}

	@Test
	public void shouldReturnEmptyListForNotExistingCourse() {
		List<Runner> runnerList= runnerService.getRunners(123L);

		assertThat(runnerList.size(),equalTo(0));
	}
}
