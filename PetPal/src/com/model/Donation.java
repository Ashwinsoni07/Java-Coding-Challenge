package com.model;

import com.dao.Donation;

public abstract class Donation {
	//donation_id,donor_name,donation_type,donation_amount,donation_item,donation_date
	private int donationId;
	private String donorName;
	private String donationType;
	private double donationAmount;
	
	abstract Donation recordDonation();
	
	public int getDonationId() {
		return donationId;
	}
	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getDonationType() {
		return donationType;
	}
	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}
	public double getDonationAmount() {
		return donationAmount;
	}
	public void setDonationAmount(double donationAmount) {
		this.donationAmount = donationAmount;
	}
	public Donation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Donation(int donationId, String donorName, String donationType, double donationAmount) {
		super();
		this.donationId = donationId;
		this.donorName = donorName;
		this.donationType = donationType;
		this.donationAmount = donationAmount;
	}
	@Override
	public String toString() {
		return "Donation [donationId=" + donationId + ", donorName=" + donorName + ", donationType=" + donationType
				+ ", donationAmount=" + donationAmount + "]";
	}
	
	
	
}
