package com.course.rabbitmqtwo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.course.rabbitmqtwo.entity.DummyMessage;

@Service
public class DummyConsumerPrefetch {

	private static final Logger logger = LoggerFactory.getLogger(DummyConsumerPrefetch.class);
	
	@RabbitListener(queues = "q.dummy", concurrency = "2")
	public void listenDummy(DummyMessage message) throws InterruptedException {
		logger.info("Message is {}", message);
		Thread.sleep(20000);
	}
}
