package com.course.rabbitmqtwo.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class RabbitmqScheduler {

	@Autowired
	private RabbitListenerEndpointRegistry rabbitmqListenerEndpointRegistry;
	
	private static final Logger logger = LoggerFactory.getLogger(RabbitmqScheduler.class);
	
	@Scheduled(cron = "0 42 10 * * ?")
	public void stopAll() {
		rabbitmqListenerEndpointRegistry
			.getListenerContainers()
			.forEach(
				listener -> {
					logger.info("Stopping container : {}", listener);
					listener.stop();
				}
			);
	}

	@Scheduled(cron = "1 44 10 * * ?")
	public void startAll() {
		rabbitmqListenerEndpointRegistry
			.getListenerContainers()
			.forEach(
				listener -> {
					logger.info("Starting container : {}", listener);
					listener.start();
				}
			);
	}
}
