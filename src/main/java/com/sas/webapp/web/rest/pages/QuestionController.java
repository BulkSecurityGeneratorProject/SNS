package com.sas.webapp.web.rest.pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;

import javax.inject.Inject;
import javax.sql.rowset.serial.SerialException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sas.webapp.domain.Question;
import com.sas.webapp.domain.SASResponse;
import com.sas.webapp.repository.pages.QuestionRepository;

@RestController
public class QuestionController {

	@Inject
	private QuestionRepository questionRepository;
	
	@RequestMapping(value = "/createQuestion", method = RequestMethod.POST)
	public SASResponse createQuestion(	@RequestParam(value = "file", required = true) MultipartFile file,
									@RequestParam(value = "question", required = true) String serializedQuestion
			) throws JsonParseException, JsonMappingException, IOException, SerialException, SQLException{
		// TODO : user id sessiondan alınacak
		ObjectMapper mapper = new ObjectMapper();
		Question question = mapper.readValue(serializedQuestion, Question.class);
		question.settUserId(4L);
		question.setQuestionDate(Calendar.getInstance().getTime());
		question.setQuestionPic(file.getBytes());
		Question q = questionRepository.save(question); 
		System.out.println(q.getQuestionDef());
		
		/*
		 * 
		 * sql örnekleri
		Date sDate = Calendar.getInstance().getTime();
		Date eDate = Calendar.getInstance().getTime();
		sDate.setHours(17);
		sDate.setMinutes(4);
		List<Question> qList = questionRepository.findByQuestionDateBetween(sDate, eDate);
		
		List<Question> q2 = questionRepository.findByTUserId(4L);
		List<Question> q3 = questionRepository.findByTLessonId(1L);*/
		
		return SASResponse.createSuccessResponse();
	}
}
