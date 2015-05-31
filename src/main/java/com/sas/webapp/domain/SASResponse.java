package com.sas.webapp.domain;

public class SASResponse {

	private String message;
	
	public SASResponse(String message){
		this.message = message;
	}
	
	public static SASResponse createErrorResponse(){
		return new SASResponse("Hata oluştu.");
	}
	
	public static SASResponse createSuccessResponse(){
		return new SASResponse("İşlem başarılı.");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
