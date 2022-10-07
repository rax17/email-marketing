package com.company.marketing.controller.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
	
	@GetMapping("/checkHealth")
	public String checkServiceHealth() {
	
		return "Send Email Service is Up and Running";
	}

}
