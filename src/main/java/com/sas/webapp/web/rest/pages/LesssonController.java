package com.sas.webapp.web.rest.pages;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sas.webapp.domain.Lesson;
import com.sas.webapp.repository.LessonRepository;

@RestController
public class LesssonController {
	
	@Inject
	private LessonRepository lessonRepository;
	
	@RequestMapping(value = "/getLessons", method = RequestMethod.GET)
	public List<Lesson> getLessons(){
		List<Lesson> lessons = lessonRepository.findAll(); 
		return lessons;
	}	
	
}
