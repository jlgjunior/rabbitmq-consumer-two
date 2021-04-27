package com.course.rabbitmqtwo.consumer;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.course.rabbitmqtwo.entity.DummyMessage;

//@Service
public class MultiplePrefetchConsumer {

	private static final Logger logger = LoggerFactory.getLogger(MultiplePrefetchConsumer.class);
	
	//@RabbitListener(queues = "q.transaction", concurrency = "2")
	public void listenTransaction(DummyMessage message) throws InterruptedException {
		logger.info("Taking transaction {}", message);
		TimeUnit.MILLISECONDS.sleep(100);
	}
	
	//@RabbitListener(queues = "q.scheduler", concurrency = "2", containerFactory = "prefetchOneContainerFactory")
	public void listenScheduler(DummyMessage message) throws InterruptedException {
		logger.info("Taking scheduler {}", message);
		TimeUnit.MINUTES.sleep(1);
	}
}
