package io.pivotal.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContactDataServiceApplication {

	final static String queueName = "contact-change-event";
	private static final Log log = LogFactory.getLog(ContactDataServiceApplication.class);
	
	@Value("${spring.rabbitmq.host}")
	String amqp_host;
	@Value("${spring.rabbitmq.port}")
	String amqp_port;
	@Value("${spring.rabbitmq.username}")
	String amqp_username;
	@Value("${spring.rabbitmq.password}")
	String amqp_password;
	
	public static void main(String[] args) {
		SpringApplication.run(ContactDataServiceApplication.class, args);
	}
		
	@Bean
	public Queue contactChangeEventQueue() {
		log.debug("amqp host: "+amqp_host);
		log.debug("amqp port: "+amqp_port);
		log.debug("amqp username: "+amqp_username);
		log.debug("amqp password: "+amqp_password);
		return new Queue(queueName);
	}
}