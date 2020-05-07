package com.pg.resumebuilder.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pg.resumebuilder.exception.ResumeDetailsNotFoundException;
import com.pg.resumebuilder.model.ResumeDetails;
import com.pg.resumebuilder.repo.ResumeDetailsRepository;

@RestController
@RequestMapping("/api")
public class ResumeDetailsController {
	
	@Autowired
	private ResumeDetailsRepository repository;
	
	private static final Logger log = 
			LoggerFactory.getLogger(ResumeDetailsController.class);
	
	@GetMapping("/records")
	public List<ResumeDetails> getAllRecordDetails() {
		return repository.findAll();
	}
	
	@GetMapping("/records/{id}")
	public Optional<ResumeDetails> getRecordDetails(@PathVariable int id) {
		Optional<ResumeDetails> details =  repository.findById(id);
		
		if(null == details)
			throw new ResumeDetailsNotFoundException("id-"+id+" not found");
		
		return details;
	}

	@PostMapping("/records")
	public ResponseEntity<Object> createRecord(@Valid @RequestBody ResumeDetails resume) {
		
		ResumeDetails details = repository.save(resume);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(details.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/records")
	public void deleteRecord(@RequestBody int id) {
		log.info("Record has been deleted.");
		repository.deleteById(id);
	}
			
	
}
