package com.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
@EnableHystrix
public class GatewayConfig {

	@Autowired
	private AuthenticationFilter filter;

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("AUTHENTICATION-SERVICE",
						r -> r.path("/AUTHENTICATION-SERVICE/**").uri("lb://AUTHENTICATION-SERVICE"))
				.route("QUESTION-SERVICE",
						r -> r.path("/QUESTION-SERVICE/**").uri("lb://QUESTION-SERVICE"))
				.route("QUIZ-SERVICE",
						r -> r.path("/QUIZ-SERVICE/**").uri("lb://QUIZ-SERVICE"))
				.build();
	}

}
