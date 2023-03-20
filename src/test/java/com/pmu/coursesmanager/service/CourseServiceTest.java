package com.pmu.coursesmanager.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pmu.coursesmanager.dao.model.Course;
import com.pmu.coursesmanager.dao.repository.CourseRepository;
import com.pmu.coursesmanager.dao.repository.RunnerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import javax.transaction.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CourseServiceTest {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CourseService courseService;
	@Test
	public void shouldReturnCourse() {
		//Given
		Course course= new Course();
		LocalDateTime creationDate = LocalDateTime.of(2018, 5, 20, 20, 52, 16);
		Course courseOne=new Course();
		courseOne.setName("Third Course");
		courseOne.setCreationDate(creationDate);
		courseOne.setNumber(3L);
		List<Course> arrayList=new ArrayList<Course>(1);
		arrayList.add(courseOne);
		//When
		courseRepository.save(courseOne);
		//Then
		assertThat("Course Number shouldn't be null", courseService.getCourses().get(0).getNumber(), notNullValue());
	}
}
