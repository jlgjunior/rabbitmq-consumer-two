package com.course.rabbitmqtwo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.course.rabbitmqtwo.entity.InvoiceCreatedMessage;
import com.course.rabbitmqtwo.entity.InvoicePaidMessage;

@Service
@RabbitListener(queues = "q.invoice")
public class InvoiceConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(InvoiceConsumer.class);
	
	@RabbitHandler
	public void handleInvoiceCreated(InvoiceCreatedMessage message) {
		logger.info("Invoice created: {}", message);
	}
	
	@RabbitHandler
	public void handleInvoicePaid(InvoicePaidMessage message) {

		logger.info("Invoice paid: {}", message);
	}
	
	@RabbitHandler(isDefault = true)
	public void handleDefault(Object message) {

		logger.info("Handling default: {}", message);
	}
}
