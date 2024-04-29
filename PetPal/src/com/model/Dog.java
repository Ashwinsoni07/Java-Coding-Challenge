package com.model;

public class Dog extends Pet {
	private String dogBreed;


	public Dog(String dogBreed) {
		super();
		this.dogBreed = dogBreed;
	}

	public String getDogBreed() {
		return dogBreed;
	}

	public void setDogBreed(String dogBreed) {
		this.dogBreed = dogBreed;
	}

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dog(int petId, String petName, int petAge, String petType, boolean available_for_adoption, int shelterId) {
		super(petId, petName, petAge, petType, available_for_adoption, shelterId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Dog [dogBreed=" + dogBreed + "]";
	}

}
