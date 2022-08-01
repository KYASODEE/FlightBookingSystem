package com.fbs.apigateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fbs.apigateway.filter.JwtAuthenticationFilter;

@Configuration
public class GatewayConfig {

	@Autowired
	private JwtAuthenticationFilter filter;

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes().
				route("web-security-service", r -> r.path("/api/auth/**").
						filters(f -> f.filter(filter)).uri("lb://web-security-service"))
				.route("search-service", r -> r.path("/fbs/search/**").
						filters(f -> f.filter(filter)).uri("lb://search-service"))
				.route("booking-service", r -> r.path("/fbs/booking/**").
						filters(f -> f.filter(filter)).uri("lb://booking-service"))
				.route("checkin-service", r -> r.path("/fbs/checkin/**").
						filters(f -> f.filter(filter)).uri("lb://checkin-service"))
				.route("Paytm-Payment-Service", r -> r.path("/fbs/payment/**").
						filters(f -> f.filter(filter)).uri("lb://Paytm-Payment-Service")).
				build();
	}
}
