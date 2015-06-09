package com.sas.webapp.domain;

public class CompositeComment {

	private Comment comment;

	private String userName;
	
	public CompositeComment(Comment comment, String userName) {
		this.comment = comment;
		this.setUserName(userName);
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
	
}
