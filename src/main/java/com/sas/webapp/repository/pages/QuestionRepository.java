package com.sas.webapp.repository.pages;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sas.webapp.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	public List<Question> findByQuestionValue(Long qValue);
	
	public List<Question> findByQuestionDateBetween(Date sDate, Date eDate);
	
	public List<Question> findByTUserIdAndTLessonId(Long userId, Long lessonId);
	
	public List<Question> findByTLessonId(Long lessonId);
}
