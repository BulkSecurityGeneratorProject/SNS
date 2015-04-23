package com.sas.webapp.repository.pages;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sas.webapp.domain.User;

public interface SolveQuestionRepository extends JpaRepository<User, Long>{

	User findById(Long id);
}
