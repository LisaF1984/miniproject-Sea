package com.qa.projectsea.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.qa.projectsea.domain.Fish;
import com.qa.projectsea.repo.FishRepo;

@Service

public class FishService {
	
	private FishRepo repo;        
	
	public FishService(FishRepo repo) {
		this.repo = repo; 
	}
	
	public Fish create(Fish f) {
		return this.repo.saveAndFlush(f);
	}
	
	public List<Fish> read(){
		return this.repo.findAll();
	
	}
	
	public Fish replace (Long id, Fish newf) {
		Fish existing = this.repo.getById(id);
		existing.setName(newf.getName());
		existing.setColour(newf.getColour());
		existing.setLengthInches(newf.getLengthInches());
		existing.setColdWater(newf.isColdWater());
		Fish updated = this.repo.save(existing);
		return updated;
	}
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id); 
	}
}
