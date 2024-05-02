package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.exception.PolicyNotFoundException;
import com.model.Client;
import com.model.Policy;
import com.service.PolicyService;

public class InsuranceController {
	public static void main(String[] args) throws SQLException {
		PolicyService policyService = new PolicyService();
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------WELCOME-----------");
		while (true) {
			System.out.println("Press 1 to Create Policy");
			System.out.println("Press 2 to Get Policy");
			System.out.println("Press 3 to Get All Policies");
			System.out.println("Press 4 to Update Policy");
			System.out.println("Press 5 to Delete Policy");
			System.out.println("Press 6 to Get Client by policyId");
			System.out.println("Press 0 to Exit");

			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting...");
				break;
			}
			switch (input) {
			case 1:
				System.out.println("---------Create Policy----------");
				Random random = new Random();
				int randomNumber = random.nextInt();

				int policyId = (randomNumber < 0) ? randomNumber * (-1) : randomNumber;
				sc.nextLine();
				System.out.println("Enter Policy Name");
				String policyName = sc.nextLine();

				System.out.println("Enter Policy Premium");
				double premium = sc.nextDouble();

				System.out.println("Enter Policy Intrest");
				double rateOfInterest = sc.nextDouble();

				Policy newPolicy = new Policy(policyId, policyName, premium, rateOfInterest);
				int status;
				try {
					status = policyService.createPolicy(newPolicy);
					if (status != 0) {
						System.out.println("Policy Added");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 2:
				List<Policy> list = policyService.getAllPolicies();
				for (Policy p : list) {
					System.out.println(p);
				}
				System.out.println("Enter PolicyId");
				int policyId1 = sc.nextInt();

				Policy policy;
				try {
					policy = policyService.getPolicy(policyId1);
					System.out.println(policy);
				} catch (SQLException | PolicyNotFoundException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 3:
				try {
					List<Policy> list1 = policyService.getAllPolicies();

					for (Policy p : list1) {
						System.out.println(p);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
				try {
					System.out.println("Select policyId from the List to Update ");
					List<Policy> list2 = policyService.getAllPolicies();
					for (Policy p : list2) {
						System.out.println(p);
					}
					System.out.println("Enter PolicyId");
					int policyId2 = sc.nextInt();

					System.out.println("Enter Policy Name");
					String newName = sc.nextLine();

					System.out.println("Enter Policy Premium");
					double newPremium = sc.nextDouble();

					System.out.println("Enter Policy Intrest");
					double newRateOfInterest = sc.nextDouble();

					Policy policy1 = new Policy();
					policy1.setPolicyId(policyId2);
					policy1.setName(newName);
					policy1.setPremium(newPremium);
					policy1.setRateOfInterest(newRateOfInterest);

					boolean status1 = policyService.updatePolicy(policy1);
					if (status1) {
						System.out.println("Policy Updated");
					}

				} catch (SQLException | PolicyNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				try {
					System.out.println("Select policyId from the List to Delete ");
					List<Policy> list2 = policyService.getAllPolicies();
					for (Policy p : list2) {
						System.out.println(p);
					}
					System.out.println("Enter PolicyId");
					int policyId2 = sc.nextInt();

					boolean status1 = policyService.deletePolicy(policyId2);
					if (status1) {
						System.out.println("Policy Deleted");
					}

				} catch (SQLException | PolicyNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 6:
				System.out.println("Select policyId to List Client ");
				List<Policy> list2 = policyService.getAllPolicies();
				for (Policy p : list2) {
					System.out.println(p);
				}
				System.out.println("Enter PolicyId");
				int policyId2 = sc.nextInt();
				
				try {
					Client client = policyService.getClient(policyId2);
					System.out.println(client);
				} catch (PolicyNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			}
		}
	}

	public static void policyMenu() {
		String[] arr = { "" };
		try {
			main(arr);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
