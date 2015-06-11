package com.sas.webapp.web.rest.pages;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.sql.rowset.serial.SerialException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sas.webapp.config.Constants;
import com.sas.webapp.domain.CompositeQuestion;
import com.sas.webapp.domain.DonutData;
import com.sas.webapp.domain.LineData;
import com.sas.webapp.domain.Question;
import com.sas.webapp.domain.SASResponse;
import com.sas.webapp.repository.UserRepository;
import com.sas.webapp.repository.pages.QuestionRepository;

@RestController
public class QuestionController {

	@Inject
	private QuestionRepository questionRepository;
	
	@Inject
	private UserRepository userRepository;
	
	@RequestMapping(value = "/createQuestion", method = RequestMethod.POST)
	public SASResponse createQuestion(	@RequestParam(value = "file", required = false) MultipartFile file,
										@RequestParam(value = "question", required = true) String serializedQuestion
			) throws JsonParseException, JsonMappingException, IOException, SerialException, SQLException{
		/* Sessiondan username alıp user ın idsini bulma 
		 * User bizim obje değil --> import org.springframework.security.core.userdetails.User */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User u = (User) auth.getPrincipal();
		Long userId = userRepository.findOneByLogin(u.getUsername()).getId();
		/* Sessiondan username alıp user ın idsini bulma */
		ObjectMapper mapper = new ObjectMapper();
		Question question = mapper.readValue(serializedQuestion.getBytes(Charset.forName("UTF-8")), Question.class);
		
		question.settUserId(userId);
		
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
	
	@RequestMapping(value = "/getQuestionsByLessonId", method = RequestMethod.GET)
	public List<CompositeQuestion> getQuestionsByLessonId(
			@RequestParam(value = "lessonId", required = true) Long lessonId){	
		List<Question> q3 = questionRepository.findByTLessonId(lessonId); 
		List<CompositeQuestion> qList = new ArrayList<CompositeQuestion>(q3.size());
		for (Question question : q3) {
			qList.add(new CompositeQuestion(question, userRepository.findOneById(question.gettUserId()).getLogin()));
		}
		return qList;
	}	
	
	@RequestMapping(value = "/getQuestionsByLessonIdUnsolved", method = RequestMethod.GET)
	public List<CompositeQuestion> getQuestionsByLessonIdUnsolved(
			@RequestParam(value = "lessonId", required = true) Long lessonId, @RequestParam(value = "unsolvedQuestions", required = true) boolean unsolvedQuestions){	
		List<Question> q3 = questionRepository.findByTLessonIdAndQuestionValueEquals(lessonId, 0); 
		List<CompositeQuestion> qList = new ArrayList<CompositeQuestion>(q3.size());
		for (Question question : q3) {
			qList.add(new CompositeQuestion(question, userRepository.findOneById(question.gettUserId()).getLogin()));
		}
		return qList;
	}
	
	@RequestMapping(value = "/getQuestionsByUserId", method = RequestMethod.GET)
	public List<Question> getQuestionsByUserIdAndLessonId(@RequestParam(value = "lessonId", required = true) Long lessonId){
	 /* User bizim obje değil --> import org.springframework.security.core.userdetails.User */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User u = (User) auth.getPrincipal();
		Long userId = userRepository.findOneByLogin(u.getUsername()).getId();
		/* Sessiondan username alıp user ın idsini bulma */
		List<Question> questionList = questionRepository.findByTUserIdAndTLessonId(userId, lessonId); 
		
		return questionList;
	}	
	
	// donut chart 
	@RequestMapping(value = "getQuestionsByUserIdGroupByLesson", method = RequestMethod.GET)
	public List<DonutData> getQuestionsByUserIdGroupByLesson(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User u = (User) auth.getPrincipal();
		Long userId = userRepository.findOneByLogin(u.getUsername()).getId();
		List<Object> out = questionRepository.findQuestionsByTUserIdGroupByLesson(userId);
		List<DonutData> donutDatas = new ArrayList<DonutData>(out.size());
		for (int i = 0; i < out.size(); i++) {
			Object[] list = (Object[]) out.get(i);
			donutDatas.add(new DonutData(
						(String)list[0],
						(Long) list[1],
						Constants.LESSON_COLORS[i]
					));
		}
		return donutDatas;
	}
	
	// line chart
	@RequestMapping(value = "getQuestionsByUserIdForYear", method = RequestMethod.GET)
	public LineData getQuestionsByUserIdForYear(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User u = (User) auth.getPrincipal();
		Long userId = userRepository.findOneByLogin(u.getUsername()).getId();
		Date endDate = Calendar.getInstance().getTime();
		Date startDate = Calendar.getInstance().getTime();
		startDate.setYear(startDate.getYear() - 1);
		List<Object> qList = questionRepository.findByQuestionDateBetweenAndTUserIdOrderByQuestionDateAsc(startDate, endDate, userId);
		
		List<String> months = new ArrayList<String>(qList.size());
		List<Long> values = new ArrayList<Long>(qList.size());
		for (int i = 0; i < qList.size(); i++) {
			Object[] obj = (Object[]) qList.get(i);
			months.add(Constants.MONTHS[(Integer) obj[0] - 1]);
			values.add((Long)obj[1]);
		}
		return new LineData(months, values);
	}
	
}
