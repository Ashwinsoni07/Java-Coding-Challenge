package com.model;

public class Claim {
	private int claim_id;
	private int claim_num;
	private String filedDate;
	private double claimAmount;
	private String status;
	private int policyId;
	private int clientId;
	public int getClaim_id() {
		return claim_id;
	}
	public void setClaim_id(int claim_id) {
		this.claim_id = claim_id;
	}
	public int getClaim_num() {
		return claim_num;
	}
	public void setClaim_num(int claim_num) {
		this.claim_num = claim_num;
	}
	public String getFiledDate() {
		return filedDate;
	}
	public void setFiledDate(String filedDate) {
		this.filedDate = filedDate;
	}
	public double getAmount() {
		return claimAmount;
	}
	public void setAmount(double amount) {
		this.claimAmount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "Claim [claim_id=" + claim_id + ", claim_num=" + claim_num + ", filedDate=" + filedDate + ", amount="
				+ claimAmount + ", status=" + status + ", policyId=" + policyId + ", clientId=" + clientId + "]";
	}
	public Claim(int claim_id, int claim_num, String filedDate, double amount, String status, int policyId,
			int clientId) {
		super();
		this.claim_id = claim_id;
		this.claim_num = claim_num;
		this.filedDate = filedDate;
		this.claimAmount = amount;
		this.status = status;
		this.policyId = policyId;
		this.clientId = clientId;
	}
	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}
}
