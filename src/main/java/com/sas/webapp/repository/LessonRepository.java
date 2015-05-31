package com.sas.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sas.webapp.domain.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
	
	public Lesson findById(Long id);

}
