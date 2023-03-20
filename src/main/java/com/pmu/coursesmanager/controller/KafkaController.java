package com.pmu.coursesmanager.controller;

import com.pmu.coursesmanager.service.CourseService;
import com.pmu.coursesmanager.service.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/kafka")
public class KafkaController {
    @Autowired
    private TopicProducer topicProducer;
    @Autowired
    private CourseService courseService;
    @GetMapping(value = "/send")
    public void send(){
        topicProducer.send(this.courseService.getCourses());
    }
}