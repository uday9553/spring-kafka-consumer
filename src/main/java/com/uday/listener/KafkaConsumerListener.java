package com.uday.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.uday.model.Employee;

@Service
public class KafkaConsumerListener {

	@KafkaListener(topics = "uday" )
	public void consumeKafkaMessages(@Payload String message) {
		System.out.println("consumed from kafka "+message);
	}
	
	@KafkaListener(topics="udayjson1",containerFactory = "employeekafkaListenerContainerFactory")
	public void consumeEmployeeObject(Employee employee) {
		System.out.println("consumed json message"+employee.toString());
	}
}
