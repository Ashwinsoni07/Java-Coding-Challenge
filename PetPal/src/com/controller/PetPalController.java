package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.model.Cat;
import com.model.Dog;
import com.model.Pet;
import com.service.PetService;

public class PetPalController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PetService petService = new PetService();
		System.out.println("--------WELCOME TO PET PAL----------");
		while (true) {
			System.out.println("Press 1 to Add Pet");
			System.out.println("Press 2 to Remove Pet");
			System.out.println("Press 3 to List Available Pets");
			System.out.println("Press 0 TO EXIT");

			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting...");
				break;
			}

			switch (input) {
			case 1:
				try {
					Random random = new Random();
					int randomNumber = random.nextInt();
					int petId = randomNumber < 0 ? randomNumber * (-1) : randomNumber;
					sc.nextLine();
					System.out.println("Enter Pet Name");
					String petName = sc.nextLine();
					System.out.println("Enter petAge");
					int petAge = sc.nextInt();
					System.out.println("Enter petBreed");
					String petBreed = sc.nextLine();
					System.out.println("Enter petType");
					String petType = sc.nextLine();
					System.out.println("Enter shelterId");
					int shelterId = sc.nextInt();
					System.out.println("EnterpetColour");
					String petColour = sc.nextLine();
					boolean availableForAdoption = true;
					Pet pet = new Pet(petId, petName, petAge, petType, availableForAdoption, shelterId);
					Cat cat = new Cat(petColour);
					Dog dog = new Dog(petBreed);

					int status = petService.addPet(pet, cat, dog);
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			case 2:
				try {
					List<Pet> list = petService.findAll();
					System.out.println("Select the petId you want to remove");
					for (Pet p : list) {
						System.out.println(p);
					}

					int petId = sc.nextInt();
					int status = petService.removePet(petId);

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				try {
				List<Pet> list = petService.findAll();
				
				for (Pet p : list) {
					System.out.println(p);
				}
				break;
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			}
		}

	}
}
