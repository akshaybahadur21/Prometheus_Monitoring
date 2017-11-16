package com.akshaybahadur21.iCoin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;


@SpringBootApplication
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
public class ICoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ICoinApplication.class, args);
	}
}
