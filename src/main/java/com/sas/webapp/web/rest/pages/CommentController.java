package com.sas.webapp.web.rest.pages;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.sas.webapp.domain.Comment;
import com.sas.webapp.domain.CompositeComment;
import com.sas.webapp.repository.UserRepository;
import com.sas.webapp.repository.pages.CommentRepository;

@RestController
public class CommentController {
	
	@Inject
	private CommentRepository commentRepository;
	
	@Inject
	private UserRepository userRepository;
	
	@RequestMapping(value = "/createComment", method = RequestMethod.POST)
	public List<CompositeComment> createComment(	@RequestParam(value = "file", required = false) MultipartFile file,
										@RequestParam(value = "comment", required = true) String serializedComment
			) throws JsonParseException, JsonMappingException, IOException, SerialException, SQLException{
		
		ObjectMapper mapper = new ObjectMapper();
		
		/* Sessiondan username alıp user ın idsini bulma 
		 * User bizim obje değil --> import org.springframework.security.core.userdetails.User */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User u = (User) auth.getPrincipal();
		Long userId = userRepository.findOneByLogin(u.getUsername()).getId();
		/* Sessiondan username alıp user ın idsini bulma */
		
		Comment comment = mapper.readValue(serializedComment.getBytes(Charset.forName("UTF-8")), Comment.class);
		comment.settUserId(userId);
		comment.setCommentDate(Calendar.getInstance().getTime());
		if(file != null){
			comment.setCommentPic(file.getBytes());
		}
		Comment q = commentRepository.save(comment); 
		System.out.println(q.getCommentColumn());
		
		
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
		
		return getComments(q.gettQuestionId());
	}
	
	@RequestMapping(value = "/getCommentsByQuestionId", method = RequestMethod.GET)
	public List<CompositeComment> getCommentsByQuestionId(@RequestParam Long questionId){
		return getComments(questionId);
	}	
	
	private List<CompositeComment> getComments(Long questionId){
		List<Comment> comments = commentRepository.findByTQuestionId(questionId);
		List<CompositeComment> compositeComments = new ArrayList<CompositeComment>(comments.size());
		
		for (Comment comment : comments) {
			compositeComments.add(new CompositeComment(comment, userRepository.findOneById(comment.gettUserId()).getLogin()));
		}
		return compositeComments;
	}
	
	
	
}

