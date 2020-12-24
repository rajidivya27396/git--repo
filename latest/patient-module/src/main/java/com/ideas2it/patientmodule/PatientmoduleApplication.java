package com.ideas2it.patientmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Implementing patientmodule
 *
 * @author Rajalakshmi
 */
@SpringBootApplication
@EnableCaching
public class PatientmoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientmoduleApplication.class, args);
	}

}
