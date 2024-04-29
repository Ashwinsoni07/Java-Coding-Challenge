package com.model;

public class DonationItem extends Donation{
	
	private String itemType;

	
	@Override
	public String toString() {
		return "DonationItem [itemType=" + itemType + "]";
	}

	public DonationItem(String itemType) {
		super();
		this.itemType = itemType;
	}

	public DonationItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
//Item Donation
	@Override
	Donation recordDonation() {
		// TODO Auto-generated method stub
		return null;
	}

}
