package com.model;

import com.dao.DonationDao;

public class CashDonation extends Donation implements DonationDao{
	
	private String donationDate;
	
	@Override
	public String toString() {
		return "CashDonation [donationDate=" + donationDate + "]";
	}

	public CashDonation(String donationDate) {
		super();
		this.donationDate = donationDate;
	}

	public CashDonation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(String donationDate) {
		this.donationDate = donationDate;
	}
//cash
	@Override
	public Donation recordDonation() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
