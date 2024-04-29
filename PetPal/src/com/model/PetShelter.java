package com.model;

public class PetShelter {
	//shelter_id,shelter_name,location,donation_id
	private int shelterId;
	private String shelterName;
	private String location;
	private int donationId;
	
	public int getShelterId() {
		return shelterId;
	}

	public void setShelterId(int shelterId) {
		this.shelterId = shelterId;
	}

	public String getShelterName() {
		return shelterName;
	}

	public void setShelterName(String shelterName) {
		this.shelterName = shelterName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getDonationId() {
		return donationId;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	@Override
	public String toString() {
		return "PetShelter [shelterId=" + shelterId + ", shelterName=" + shelterName + ", location=" + location
				+ ", donationId=" + donationId + "]";
	}

	public PetShelter(int shelterId, String shelterName, String location, int donationId) {
		super();
		this.shelterId = shelterId;
		this.shelterName = shelterName;
		this.location = location;
		this.donationId = donationId;
	}

	public PetShelter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
