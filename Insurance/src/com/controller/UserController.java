package com.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.exception.InvalidCredentialException;
import com.model.User;
import com.service.UserService;

public class UserController {
	public static void main(String[] args) {
		UserService loginService = new UserService();
		Scanner sc = new Scanner(System.in);
		System.out.println("-------Welcome User-----------");
		while(true) {
			System.out.println("Press 1 to Login");
			//System.out.println("Press 2 to Sign Up");
			System.out.println("Press 0 to Exit");
			
			int input = sc.nextInt();
			if(input == 0) {
				break;
			}
			switch(input) {
			
			case 1:
				try {
				sc.nextLine();
				System.out.println("Enter Username");
				String username = sc.nextLine();
				
				System.out.println("Enter Password");
				String password = sc.nextLine();
				
				
					User userLogin = loginService.login(username,password);
					if (userLogin.getRole().equalsIgnoreCase("client")) {
						InsuranceController.policyMenu();
					}
						break;
					}
				} catch (InvalidCredentialException | SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					
				
				break;
			}
			
		}
		
	}
}
