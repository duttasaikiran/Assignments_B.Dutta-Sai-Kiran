package com.example.SpringBootJMSProducer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.SpringBootJMSProducer.config.RabbitMQconfiguration;

import model.Product;

@SpringBootApplication
public class SpringBootJmsProducerApplication implements CommandLineRunner {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJmsProducerApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception
	{
		Product product = new Product();
		product.setProductId(100);
		product.setName("Laptop");
		product.setQuantity(10);
		
		System.out.println("Sending message...");
		rabbitTemplate.convertAndSend(RabbitMQconfiguration.topicExchangeName,
				"message_routing_key", "Hello this is message not an object");
		System.out.println("Message sent successfully...");
	}
}
