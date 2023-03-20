package com.pmu.coursesmanager.service;

import com.pmu.coursesmanager.dao.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    private  KafkaTemplate<String, String> kafkaTemplate;
    public void send(List<Course> course){
        kafkaTemplate.send(topicName, course.toString());
    }

}