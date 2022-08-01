package com.fbs.paytm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PaytmPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaytmPaymentApplication.class, args);
	}

}
