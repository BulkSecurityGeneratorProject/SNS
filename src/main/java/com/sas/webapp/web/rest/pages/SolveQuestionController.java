package com.sas.webapp.web.rest.pages;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sas.webapp.domain.User;
import com.sas.webapp.repository.pages.SolveQuestionRepository;

@RestController
public class SolveQuestionController {
	
	@Inject
	SolveQuestionRepository repo;
	
	
}
