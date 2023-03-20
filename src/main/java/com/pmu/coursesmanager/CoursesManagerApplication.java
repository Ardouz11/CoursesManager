package com.pmu.coursesmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class CoursesManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursesManagerApplication.class, args);
	}

}
