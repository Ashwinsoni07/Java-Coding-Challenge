package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.PolicyDao;
import com.dao.PolicyDaoImpl;
import com.exception.PolicyNotFoundException;
import com.model.Client;
import com.model.Policy;

public class PolicyService {
	PolicyDao dao = new PolicyDaoImpl();
	public int createPolicy(Policy policy) throws SQLException {
		
		return dao.add(policy);
	}
	public List<Policy> getAllPolicies() throws SQLException {
		
		return dao.getAllPolicies();
	}
	public Policy getPolicy(int policyId1) throws SQLException, PolicyNotFoundException {
		boolean isValid = dao.findOne(policyId1);
		if(!(dao.findOne(policyId1)))
			throw new PolicyNotFoundException("Invalid policyId!");
		return dao.getPolicy(policyId1);
	}
	public boolean updatePolicy(Policy policy1) throws SQLException, PolicyNotFoundException {
		boolean isValid = dao.findOne(policy1.getPolicyId());
		if(!(dao.findOne(policy1.getPolicyId())))
			throw new PolicyNotFoundException("Invalid policyId!");
		return dao.updatePolicy(policy1);
	}
	public boolean deletePolicy(int policyId2) throws PolicyNotFoundException, SQLException {
		boolean isValid = dao.findOne(policyId2);
		if(!(dao.findOne(policyId2)))
			throw new PolicyNotFoundException("Invalid policyId!");
		return dao.deletePolicy(policyId2);
	}
	public Client getClient(int policyId2) throws PolicyNotFoundException, SQLException {
		boolean isValid = dao.findOne(policyId2);
		if(!(dao.findOne(policyId2)))
			throw new PolicyNotFoundException("Invalid policyId!");
		
		return dao.getClient(policyId2);
	}

}
