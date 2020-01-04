package com.real.athletic.index.rest.template.service;

public interface RestTemplateService {

	String sendOTPSMS(String otp, String mobileNumber);

	String verifyOTPSMS(String otp, String sessionId);

}
