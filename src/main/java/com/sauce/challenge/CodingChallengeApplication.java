package com.sauce.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * <p>This class is responsible to start / bootstrap the application</p>
 * <p>This class should be run in order to start the health monitoring service </p>
 * <p>This will eventually initialize the spring scheduler {@code HealthChkScheduler} 
 *    which in turn invokes the site health check module</p>
 * 
 * @author owner
 * @since 20-01-2019
 * @version 1.0
 *
 */
@SpringBootApplication
// This annotation is required to enable the spring scheduling in the application  
@EnableScheduling
public class CodingChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingChallengeApplication.class, args);
	}

}

