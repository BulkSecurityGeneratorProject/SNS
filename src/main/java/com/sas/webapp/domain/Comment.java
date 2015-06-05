package com.sas.webapp.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "T_COMMENT")
public class Comment implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "t_question_id", length = 11)
	private Long tQuestionId;
	
	@Column(name = "comment_col")
	private String commentColumn;

	@Column(name = "comment_date")
	private Date commentDate;
	
	@Column(name = "t_user_id", length = 20)
	private Long tUserId;
	
	@Column(name = "comment_pic")
	private byte[] commentPic;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long gettQuestionId() {
		return tQuestionId;
	}

	public void settQuestionId(Long tQuestionId) {
		this.tQuestionId = tQuestionId;
	}

	public String getCommentColumn() {
		return commentColumn;
	}

	public void setCommentColumn(String commentColumn) {
		this.commentColumn = commentColumn;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public Long gettUserId() {
		return tUserId;
	}

	public void settUserId(Long tUserId) {
		this.tUserId = tUserId;
	}

	public byte[] getCommentPic() {
		return commentPic;
	}

	public void setCommentPic(byte[] commentPic) {
		this.commentPic = commentPic;
	}

	
	
}
