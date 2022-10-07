package com.company.marketing.controller.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.marketing.controller.EmailController;
import com.company.marketing.model.request.EmailRequest;
import com.company.marketing.model.response.EmailResponse;
import com.company.marketing.service.EmailService;

@RestController
public class EmailControllerImpl implements EmailController {
	
	//Simple Test
	
	//http://localhost:8080/v1/email?isTest=yes
	
	/*
	request
	
	{
	    "recptEmailId": "a@gmail.com",
	    "emailBody": "email . content",
	    "action": "send"
	}
	
	Response
	
	{
	    "statusCode": "200",
	    "status": "ok",
	    "description": "Email successfully sent to a@gmail.com on 2022/10/07 10:47:49"
	}
	
	*/

	@Autowired
	EmailService emailService;

	@Override

	@PostMapping("/v1/email")
	public ResponseEntity<EmailResponse> processEmail(@RequestBody EmailRequest request,
			@RequestParam(required = false) String isTest) {
		EmailResponse response = new EmailResponse();

		if (request.getAction().equalsIgnoreCase("send")) {

			if (isTest.equalsIgnoreCase("yes")) {

				response.setStatusCode("200");
				response.setStatus("ok");

				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();

				response.setDescription("Email successfully sent to " + request.getRecptEmailId() + " on "
						+ dateFormat.format(cal.getTime()));

				return ResponseEntity.status(HttpStatus.valueOf(Integer.valueOf(response.getStatusCode())))
						.body(response);

			} else {
				return emailService.sendEmail(request);
			}

		}

		else if (request.getAction().equalsIgnoreCase("notify")) {

			return emailService.sendEmail(request);
		}

		else {

			response.setStatusCode("400");
			response.setStatus("Bad Request");
			response.setDescription("Action is mandatory, It can be one of send or notify");
			return ResponseEntity.status(HttpStatus.valueOf(Integer.valueOf(response.getStatusCode()))).body(response);

		}

	}

}
