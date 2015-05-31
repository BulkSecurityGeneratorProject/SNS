package com.sas.webapp.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author KCB
 *
 */
@Entity
@Table(name = "T_QUESTION")
public class Question implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "question_date")
	private Date questionDate;
	
	@Column(name = "question_value")
	private int questionValue;

	@Column(name = "question_def")
	private String questionDef;
	
	@Column(name = "t_user_id", length = 20)
	private Long tUserId;
	
	@Column(name = "t_lesson_id", length = 11)
	private Long tLessonId;
	
	@Column(name = "question_pic")
	private byte[] questionPic;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(Date questionDate) {
		this.questionDate = questionDate;
	}

	public int getQuestionValue() {
		return questionValue;
	}

	public void setQuestionValue(int questionValue) {
		this.questionValue = questionValue;
	}

	public String getQuestionDef() {
		return questionDef;
	}

	public void setQuestionDef(String questionDef) {
		this.questionDef = questionDef;
	}

	public Long gettUserId() {
		return tUserId;
	}

	public void settUserId(Long tUserId) {
		this.tUserId = tUserId;
	}

	public Long gettLessonId() {
		return tLessonId;
	}

	public void settLessonId(Long tLessonId) {
		this.tLessonId = tLessonId;
	}

	public byte[] getQuestionPic() {
		return questionPic;
	}

	public void setQuestionPic(byte[] questionPic) {
		this.questionPic = questionPic;
	}

	
	
	
}
