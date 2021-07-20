package com.qa.projectsea.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.projectsea.domain.Fish;

@Repository
public interface FishRepo extends JpaRepository<Fish, Long>{
	

	
}
