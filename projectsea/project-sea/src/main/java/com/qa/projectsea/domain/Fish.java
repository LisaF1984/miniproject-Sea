package com.qa.projectsea.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fish {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String colour;
	private int lengthInches;
	private boolean coldWater;
	
	public Fish() {
		
	}

	public Fish(Long id, String name, String colour, int lengthInches, boolean coldWater) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.lengthInches = lengthInches;
		this.coldWater = coldWater;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getLengthInches() {
		return lengthInches;
	}

	public void setLengthInches(int lengthInches) {
		this.lengthInches = lengthInches;
	}

	public boolean isColdWater() {
		return coldWater;
	}

	public void setColdWater(boolean coldWater) {
		this.coldWater = coldWater;
	}
	
}
