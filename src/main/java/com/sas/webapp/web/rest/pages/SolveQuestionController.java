package com.sas.webapp.web.rest.pages;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sas.webapp.domain.User;
import com.sas.webapp.repository.pages.SolveQuestionRepository;

@RestController
@RequestMapping("/pages")
public class SolveQuestionController {
	
	@Inject
	SolveQuestionRepository repo;
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public User getUsers(@RequestParam int userId){
		User user = repo.findById((long)userId);
		return user;
	}
}
