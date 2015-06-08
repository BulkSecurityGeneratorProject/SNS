package com.sas.webapp.repository.pages;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sas.webapp.domain.Comment;



public interface CommentRepository extends JpaRepository<Comment, Long> {
	
    
	
	public List<Comment> findByCommentDateBetween(Date sDate, Date eDate);
	
	public List<Comment> findByTUserId(Long userId);
	
	public List<Comment> findByTQuestionId(Long questionId);
	
	
}
