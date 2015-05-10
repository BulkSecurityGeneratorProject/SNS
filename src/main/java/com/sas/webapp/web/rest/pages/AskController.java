package com.sas.webapp.web.rest.pages;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sas.webapp.repository.pages.AskRepository;

@RestController
public class AskController {
	
	@Inject
	AskRepository repo;
	
	@RequestMapping(value="/pages/question/upload", consumes = MediaType.ALL_VALUE, method = RequestMethod.POST) 
	public boolean handleImageUpload(@RequestBody HttpEntity<byte[]> requestEntity) {
	    byte[] payload = requestEntity.getBody();
	    HttpHeaders headers = requestEntity.getHeaders();
	    System.out.println("geldik");
	    return true;
	}
}