package com.pmu.coursesmanager.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pmu.coursesmanager.service.CourseService;
import com.pmu.coursesmanager.service.RunnerService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest
public abstract class AbstractControllerTest {

	@Autowired
	protected MockMvc mockMvc;

	@MockBean
	protected CourseService courseService;

	@MockBean
	protected RunnerService runnerService;

	@Before
	public void setUp() {
		Mockito.reset(runnerService
				, courseService);
	}

}
