package com.sas.webapp.domain;

public class CompositeQuestion {

	private Question question;
	
	private String userName;

	public CompositeQuestion(Question question, String userName) {
		super();
		this.question = question;
		this.userName = userName;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
