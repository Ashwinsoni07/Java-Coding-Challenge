package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Client;
import com.model.Policy;

public interface PolicyDao {

	int add(Policy policy) throws SQLException;

	List<Policy> getAllPolicies() throws SQLException;

	Policy getPolicy(int policyId1) throws SQLException;

	boolean findOne(int policyId1) throws SQLException;

	boolean updatePolicy(Policy policy1) throws SQLException;

	boolean deletePolicy(int policyId2) throws SQLException;

	Client getClient(int policyId2) throws SQLException;

}
