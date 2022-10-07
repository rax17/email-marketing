package com.company.marketing.model.request;

import javax.validation.constraints.NotBlank;

//Lombok can also be used

public class EmailRequest {

	// Used to add contact list to a distribution list and send email
	private String contactDistId;
	// Used to send single email for testing
	@NotBlank(message = "Recepient email ID is mandatory")
	private String recptEmailId;
	private String fromEmailId;
	@NotBlank(message = "email content is mandatory")
	private String emailBody;
	private String campaignName;
	private String emailTemplateName;
	// possible action can send to customer, notify for failure. It can be extended
	// for future
	@NotBlank(message = "action is mandatory")
	private String action;

	public EmailRequest() {

	}

	public EmailRequest(String contactDistId, String recptEmailId, String fromEmailId, String emailBody,
			String campaignName, String emailTemplateName, String action) {
		super();
		this.contactDistId = contactDistId;
		this.recptEmailId = recptEmailId;
		this.fromEmailId = fromEmailId;
		this.emailBody = emailBody;
		this.campaignName = campaignName;
		this.emailTemplateName = emailTemplateName;
		this.action = action;
	}

	public String getContactDistId() {
		return contactDistId;
	}

	public void setContactDistId(String contactDistId) {
		this.contactDistId = contactDistId;
	}

	public String getRecptEmailId() {
		return recptEmailId;
	}

	public void setRecptEmailId(String recptEmailId) {
		this.recptEmailId = recptEmailId;
	}

	public String getFromEmailId() {
		return fromEmailId;
	}

	public void setFromEmailId(String fromEmailId) {
		this.fromEmailId = fromEmailId;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getEmailTemplateName() {
		return emailTemplateName;
	}

	public void setEmailTemplateName(String emailTemplateName) {
		this.emailTemplateName = emailTemplateName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
