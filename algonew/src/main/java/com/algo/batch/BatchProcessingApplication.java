package com.algo.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class BatchProcessingApplication {
	   

		public static void main(String[] args) {
			SpringApplication.run(BatchProcessingApplication.class, args);
		}



}
