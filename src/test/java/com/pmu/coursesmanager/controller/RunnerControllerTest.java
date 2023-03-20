package com.pmu.coursesmanager.controller;

import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pmu.coursesmanager.dao.model.Course;
import com.pmu.coursesmanager.dao.model.Runner;
import com.pmu.coursesmanager.dao.model.dto.RunnersDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import javax.transaction.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RunnerControllerTest extends AbstractControllerTest {

    @Autowired  ObjectMapper objectMapper;
    @Test
	public void shouldReturnRunnersOfCourse() throws Exception {

		// given
        Course course =new Course();
        course.setNumber(1L);
        List<Runner> runners=new ArrayList<Runner>(3);
        Runner runnerOne=new Runner();
        Runner runnerTwo=new Runner();
        Runner runnerThree=new Runner();
        runnerOne.setName("Runner One");
        runnerTwo.setName("Runner Two");
        runnerThree.setName("Runner Three");
        runnerOne.setCourse(course);
        runnerTwo.setCourse(course);
        runnerThree.setCourse(course);
        runners.add(runnerOne);
        runners.add(runnerTwo);
        runners.add(runnerThree);

		// when
		when(runnerService.getRunners(1L)).thenReturn(runners);

		// then
		mockMvc.perform(get("/api/v1/courses/1/runners").accept(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].name", is("Runner One")))
				.andExpect(jsonPath("$[0].course.number", is(1)))
                .andExpect(jsonPath("$[1].name", is("Runner Two")))
                .andExpect(jsonPath("$[1].course.number", is(1)))
                .andExpect(jsonPath("$[2].name", is("Runner Three")))
                .andExpect(jsonPath("$[2].course.number", is(1)));

	}
	@Test
	public void shouldAddRunners() throws Exception {
       // given
        Course course =new Course();
        course.setNumber(1L);
        List<Runner> runners=new ArrayList<Runner>(3);
        Runner runnerOne=new Runner();
        Runner runnerTwo=new Runner();
        Runner runnerThree=new Runner();
        runnerOne.setName("Runner 1");
        runnerTwo.setName("Runner 2");
        runnerThree.setName("Runner 3");
        runnerOne.setCourse(course);
        runnerTwo.setCourse(course);
        runnerThree.setCourse(course);
        runners.add(runnerOne);
        runners.add(runnerTwo);
        runners.add(runnerThree);
        RunnersDTO runnersDTO=new RunnersDTO();
        runnersDTO.setRunners(runners);

		// when
		when(runnerService.addRunners(runners,1L)).thenReturn(runners);

        // then

        String inputJson = objectMapper.writeValueAsString(runnersDTO);
		mockMvc.perform(post("/api/v1/courses/1/runners")
				.content(inputJson)
				.contentType(APPLICATION_JSON)
				.accept(APPLICATION_JSON))
				.andExpect(status().isCreated());
	}


}
