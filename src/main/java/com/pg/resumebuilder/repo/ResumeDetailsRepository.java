package com.pg.resumebuilder.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pg.resumebuilder.model.ResumeDetails;

public interface ResumeDetailsRepository extends JpaRepository<ResumeDetails, Integer>{
	
}
