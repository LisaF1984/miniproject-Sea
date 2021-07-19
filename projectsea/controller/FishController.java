package com.qa.projectsea.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.projectsea.domain.Fish;
import com.qa.projectsea.service.FishService;

@RestController
@RequestMapping("/sea")
@CrossOrigin 

public class FishController {
	
	private FishService service;
	
	@Autowired
	public FishController(FishService service) {
		this.service = service;
		
	}

	@GetMapping("/test")
	public String test() {
		return "this is a fish test";
	}
	@PostMapping("/create")
	public ResponseEntity<Fish> create(@RequestBody Fish f) {
		return new ResponseEntity<Fish>(this.service.create(f), HttpStatus.CREATED);
	
	}
	
	@GetMapping("/read")
	public ResponseEntity<List<Fish>> read() {
		return new ResponseEntity<List<Fish>>(this.service.read(), HttpStatus.OK);
		
		
	}
	@PutMapping("/replace/{id}")
	public ResponseEntity<Fish> replace(@PathVariable Long id, @RequestBody Fish f){
		return new ResponseEntity<Fish>(this.service.replace(id, f), HttpStatus.ACCEPTED);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Fish> delete(@PathVariable Long id) {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT): 
			 new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
