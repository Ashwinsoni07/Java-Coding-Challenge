package com.model;

public class Pet {
	//pet_id,pet_name,age,breed,pet_type,available_for_adoption,shelter_id,colour
	private int petId;
	private String petName;
	private int petAge;
	private String petType;
	private boolean available_for_adoption;
	private int shelterId;
	
	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", petName=" + petName + ", petAge=" + petAge + ", petType=" + petType
				+ ", available_for_adoption=" + available_for_adoption + ", shelterId=" + shelterId + "]";
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public int getPetAge() {
		return petAge;
	}

	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public boolean isAvailable_for_adoption() {
		return available_for_adoption;
	}

	public void setAvailable_for_adoption(boolean available_for_adoption) {
		this.available_for_adoption = available_for_adoption;
	}

	public int getShelterId() {
		return shelterId;
	}

	public void setShelterId(int shelterId) {
		this.shelterId = shelterId;
	}

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pet(int petId, String petName, int petAge, String petType, boolean available_for_adoption, int shelterId) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.petAge = petAge;
		this.petType = petType;
		this.available_for_adoption = available_for_adoption;
		this.shelterId = shelterId;
	}

	public Pet(int petId2, String petName2, String type, int age, int shelterId2, String availableForAdoption,
			int eventId) {
		// TODO Auto-generated constructor stub
	}
	
	
}
