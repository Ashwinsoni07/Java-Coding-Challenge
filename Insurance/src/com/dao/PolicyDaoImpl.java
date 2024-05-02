package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Client;
import com.model.Policy;
import com.utility.DBConnection;

public class PolicyDaoImpl implements PolicyDao {

	@Override
	public int add(Policy policy) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO policy(policy_id, policy_name, premium, rate_of_interest) VALUES (?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, policy.getPolicyId());
		pstmt.setString(2, policy.getName());
		pstmt.setDouble(3, policy.getPremium());
		pstmt.setDouble(4, policy.getRateOfInterest());

		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public List<Policy> getAllPolicies() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM policy;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Policy> list = new ArrayList();
		while (rst.next()) {
			int policyId = rst.getInt("policy_id");
			String name = rst.getString("policy_name");
			double premium = rst.getDouble("premium");
			double rateOfInterest = rst.getInt("rate_of_interest");
			Policy policy = new Policy(policyId, name, premium, rateOfInterest);
			list.add(policy);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public Policy getPolicy(int policyId1) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM policy WHERE policy_id=?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, policyId1);
		ResultSet rst = pstmt.executeQuery();

		if (rst.next()) {
			Policy policy = new Policy();

			policy.setPolicyId(rst.getInt("policy_id"));
			policy.setName(rst.getString("name"));
			policy.setPremium(rst.getDouble("premium"));
			policy.setRateOfInterest(rst.getDouble("rate_of_interest"));

			DBConnection.dbClose();
			return policy;
		} else {
			DBConnection.dbClose();
			return null;
		}

	}

	@Override
	public boolean findOne(int policyId1) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT policy_id FROM policy WHERE policy_id=? AND is_active = 'yes' ";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setInt(1, policyId1);
		pstmt.setString(2, "yes");
		;
		ResultSet rst = pstmt.executeQuery();
		boolean status = rst.next();

		DBConnection.dbClose();
		return status;

	}

	@Override
	public boolean updatePolicy(Policy policy) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE policy SET policy_name = ?, premium=? , rate_of_interest=? WHERE policy_id =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(0, policy.getName());
		pstmt.setDouble(1, policy.getPremium());
		pstmt.setDouble(2, policy.getRateOfInterest());
		pstmt.setInt(3, policy.getPolicyId());

		int status = pstmt.executeUpdate();
		if (status != 0) {
			DBConnection.dbClose();
			return true;
		} else {
			DBConnection.dbClose();
			return false;
		}
	}

	@Override
	public boolean deletePolicy(int policyId2) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE policy SET is_active = ? WHERE admin_id = ? ";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "yes");
		pstmt.setInt(2, policyId2);
		int status = pstmt.executeUpdate();
		if (status != 0) {
			DBConnection.dbClose();
			return true;
		} else {
			DBConnection.dbClose();
			return false;
		}
		
	}

	@Override
	public Client getClient(int policyId2) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT c* FROM client c JOIN policy p ON c.policy_id = p.policy_id WHERE policy_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, policyId2);
		ResultSet rst = pstmt.executeQuery();
		Client client = new Client();
		if(rst.next()) {
			client.setClientId(rst.getInt("client_id"));
			client.setContactInfo(rst.getString("contact_info"));
			client.setName(rst.getString("client_name"));
			client.setPolicyId(rst.getInt("policy_id"));
			client.setUserId(rst.getInt("user_id"));
			
		}
		
		DBConnection.dbClose();
		return client;
	}

}
