package com.company.marketing.controller;

import org.springframework.http.ResponseEntity;

import com.company.marketing.model.request.EmailRequest;
import com.company.marketing.model.response.EmailResponse;

public interface EmailController {

	ResponseEntity<EmailResponse> processEmail(EmailRequest request, String isTest);

}
