package com.company.marketing.service.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.company.marketing.model.request.EmailRequest;
import com.company.marketing.model.response.EmailResponse;
import com.company.marketing.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	public ResponseEntity<EmailResponse> sendEmail(EmailRequest req) {

		EmailResponse resp = new EmailResponse();

		try {

			// ** this is just for the test purpose but in our case it will make a call to
			// get the template and fill the content received in the API call.

			// req.getCampaignName()

			// Add a tracking ID which can a UUID

			// Fetch the email Template and add the email content received in the API
			// request
			// req.getEmailTemplateName()

			// sending email from localhost, this will be the actual host for sending email
			String host = "localhost";

			// Get system properties
			Properties properties = System.getProperties();

			// Setup mail server
			properties.setProperty("mail.smtp.host", host);

			// Get the default Session object.
			Session session = Session.getDefaultInstance(properties);

			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(req.getFromEmailId()));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(req.getRecptEmailId()));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Send the actual HTML message by adding the template and content received in
			// API request
			message.setContent("<h1>" + req.getEmailBody() + "</h1>", "text/html");

			// Send message
			Transport.send(message);
			System.out.println("Email sent successfully....");

		}

		catch (Exception e) {
			e.printStackTrace();
			resp.setStatus("error in sending email");
			// can be customized
			resp.setStatusCode("500");
			resp.setDescription(e.getMessage());
			return ResponseEntity.status(HttpStatus.valueOf(Integer.valueOf(resp.getStatusCode()))).body(resp);

		}

		return ResponseEntity.status(HttpStatus.OK).body(resp);

	}

	// for any kind of failure
	@Override
	public ResponseEntity<EmailResponse> notifySender(EmailRequest req) {
		EmailResponse resp = new EmailResponse();

		try {
			//to be done
		}

		catch (Exception e) {

			resp.setStatus("error in sending email");
			// can be customized
			resp.setStatusCode("500");
			resp.setDescription(e.getMessage());
			return ResponseEntity.status(HttpStatus.valueOf(Integer.valueOf(resp.getStatusCode()))).body(resp);

		}

		return ResponseEntity.status(HttpStatus.OK).body(resp);
	}

}
