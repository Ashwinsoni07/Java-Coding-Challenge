package com.model;

public class Client {
	private int clientId;
	private int name ;
	private String contactInfo;
    private int policyId;
    private int userId ;
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", name=" + name + ", contactInfo=" + contactInfo + ", policyId="
				+ policyId + ", userId=" + userId + "]";
	}
	public Client(int clientId, int name, String contactInfo, int policyId, int userId) {
		super();
		this.clientId = clientId;
		this.name = name;
		this.contactInfo = contactInfo;
		this.policyId = policyId;
		this.userId = userId;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
}
