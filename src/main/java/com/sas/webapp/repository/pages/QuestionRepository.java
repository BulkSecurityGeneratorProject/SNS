package com.sas.webapp.repository.pages;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sas.webapp.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	public List<Question> findByQuestionValue(Long qValue);
	
	@Query("SELECT MONTH(q.questionDate), count(q.id) as count FROM Question q where q.questionDate between :sDate and :eDate and q.tUserId = :userId group by MONTH(q.questionDate) order by q.questionDate asc")
	public List<Object> findByQuestionDateBetweenAndTUserIdOrderByQuestionDateAsc(@Param("sDate") Date sDate, @Param("eDate") Date eDate, @Param("userId") Long userId);
	
	public List<Question> findByTUserIdAndTLessonId(Long userId, Long lessonId);
	
	public List<Question> findByTLessonIdAndQuestionValueEquals(Long lessonId, int questionValue);
	
	public List<Question> findByTLessonId(Long lessonId);
	
	@Modifying
	@Transactional
	@Query("UPDATE Question c SET c.questionValue = :questionValue WHERE c.id = :id")
	public int updateQuestionById(@Param("questionValue") int questionValue, @Param("id") Long id);
	
	@Query("SELECT L.lessonName, count(Q.id) as count FROM Question Q, Lesson L where Q.tUserId = :userId and L.id = Q.tLessonId group by L.lessonName")
	public List<Object> findQuestionsByTUserIdGroupByLesson(@Param("userId") Long userId);
}
