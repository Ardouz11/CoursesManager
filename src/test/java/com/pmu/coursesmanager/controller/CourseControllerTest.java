package com.pmu.coursesmanager.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pmu.coursesmanager.dao.model.Course;
import org.junit.Test;


import javax.transaction.Transactional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CourseControllerTest extends AbstractControllerTest {
	@Test
	public void shouldReturnFoundCourses() throws Exception {
		// given
		LocalDateTime creationDateOne = LocalDateTime.of(2018, 5, 20, 20, 51, 16);
		LocalDateTime creationDateTwo = LocalDateTime.of(2018, 5, 20, 20, 52, 16);
		List<Course> arrayList=new ArrayList<Course>(2);
		Course courseOne=new Course();
		courseOne.setName("First Course");
		courseOne.setCreationDate(creationDateOne);
		courseOne.setNumber(1L);
		Course courseTwo=new Course();
		courseTwo.setCreationDate(creationDateTwo);
		courseTwo.setNumber(2L);
		courseTwo.setName("Second Course");
		arrayList.add(courseOne);
		arrayList.add(courseTwo);

		// when
		when(courseService.getCourses()).thenReturn(arrayList);

		// then
		mockMvc.perform(get("/api/v1/courses").accept(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(APPLICATION_JSON))
				.andExpect(jsonPath("$[0].name", is("First Course")))
				.andExpect(jsonPath("$[0].number", is(1)))
				.andExpect(jsonPath("$[0].creationDate", is(creationDateOne.toString())))
				.andExpect(jsonPath("$[1].name", is("Second Course")))
				.andExpect(jsonPath("$[1].number", is(2)))
				.andExpect(jsonPath("$[1].creationDate", is(creationDateTwo.toString())));

	}
}
