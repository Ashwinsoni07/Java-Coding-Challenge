package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;
import com.utility.DBConnection;


public class UserDaoImpl implements UserDao {

	@Override
	public User login(String username, String password) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1,username);
		pstmt.setString(2,password);
		ResultSet rst = pstmt.executeQuery();
		if(rst.next()) {
			User user = new User();
			user.setUserId(rst.getInt("user_id"));
			user.setUsername(username);
			user.setPassword(password); 
			user.setRole(rst.getString("role"));
			DBConnection.dbClose();
			return user;
		}
		else {
			DBConnection.dbClose();
			return null;
		}
		
	}

}
