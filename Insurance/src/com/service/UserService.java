package com.service;

import java.sql.SQLException;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.exception.InvalidCredentialException;
import com.model.User;

public class UserService {
	UserDao dao = new UserDaoImpl();
	public User login(String username, String password) throws InvalidCredentialException, SQLException {
		User loginUser = dao.login(username, password);
		if (loginUser == null) {
			throw new InvalidCredentialException("Invalid Credentials");
		}

		return loginUser;

	}

}
