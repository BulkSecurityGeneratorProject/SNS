package com.sas.webapp.repository.pages;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sas.webapp.domain.Comment;



public interface CommentRepository extends JpaRepository<Comment, Long> {
	
    
	
	public List<Comment> findByCommentDateBetween(Date sDate, Date eDate);
	
	public List<Comment> findByTUserId(Long userId);
	
	public List<Comment> findByTQuestionId(Long questionId);
	
	public List<Comment> findByTQuestionIdAndCommentValueEquals(Long questionId, Integer commentValue);
	
	@Modifying
	@Transactional
	@Query("UPDATE Comment c SET c.commentValue = :commentValue WHERE c.id = :id")
	public int updateCommentById(@Param("commentValue") int commentValue, @Param("id") Long id);
	
	
}
