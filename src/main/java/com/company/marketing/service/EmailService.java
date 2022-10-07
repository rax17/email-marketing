package com.company.marketing.service;

import org.springframework.http.ResponseEntity;

import com.company.marketing.model.request.EmailRequest;
import com.company.marketing.model.response.EmailResponse;


public interface EmailService {

	ResponseEntity<EmailResponse>  sendEmail(EmailRequest req);

	ResponseEntity<EmailResponse>  notifySender(EmailRequest req);

}
