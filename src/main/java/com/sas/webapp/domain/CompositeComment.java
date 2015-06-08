package com.sas.webapp.domain;

public class CompositeComment {

	private Comment comment;
	
	private String userFirstName;
	
	private String userLastName;
	
	public CompositeComment(Comment comment, String userFirstName,
			String userLastName) {
		this.comment = comment;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	
	
}
