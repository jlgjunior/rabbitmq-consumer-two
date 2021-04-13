package com.course.rabbitmqtwo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.course.rabbitmqtwo.entity.DummyMessage;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Service
public class DummyConsumer {

	private static final Logger logger = LoggerFactory.getLogger(DummyConsumer.class);
	
	//@RabbitListener(queues = "q.dummy")
	public void listenDummy(DummyMessage message) {
		logger.info("{}", message);
	}
}
