package com.model;

public class Cat extends Pet {
	private String catColour;

	@Override
	public String toString() {
		return "Cat [catColour=" + catColour + "]";
	}

	public Cat(String catColour) {
		super();
		this.catColour = catColour;
	}

	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cat(int petId, String petName, int petAge, String petType, boolean available_for_adoption, int shelterId) {
		super(petId, petName, petAge, petType, available_for_adoption, shelterId);
		// TODO Auto-generated constructor stub
	}

	public String getCatColour() {
		return catColour;
	}

	public void setCatColour(String catColour) {
		this.catColour = catColour;
	}
}
