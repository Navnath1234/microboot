package com.AAA.BBB.PracticeSSSSSS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard

public class MicroBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroBootApplication.class, args);
		
		System.out.println("hello java");
	}}
