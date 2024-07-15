package com.sandeidevlab.Safaricom.Api.Consumption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SafaricomApiConsumptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafaricomApiConsumptionApplication.class, args);
	}
}

