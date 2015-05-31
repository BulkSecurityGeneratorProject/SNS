package com.sas.webapp.service;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sas.webapp.Application;
import com.sas.webapp.domain.Lesson;
import com.sas.webapp.repository.LessonRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class LessonServiceTest {

	  @Inject
	  private LessonRepository lessonRepository;
	  
	  @Test
	  public void testLesson(){
		  Lesson l = lessonRepository.findById(1L);
		  System.out.println(l.getLessonName());
	  }
}
