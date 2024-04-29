package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.ShelterDao;
import com.dao.ShelterDaoImpl;
import com.exception.FileHandlingException;
import com.model.Cat;
import com.model.Dog;
import com.model.Pet;

public class PetService {
	ShelterDao dao = new ShelterDaoImpl();
	public int addPet(Pet pet, Cat cat, Dog dog) throws SQLException {
		
		return dao.addPet(pet,cat,dog);
	}
	public int removePet(int petId) throws FileHandlingException, SQLException {
boolean isIdValid = dao.findOne(petId);
		
		if(!isIdValid) {
			throw new FileHandlingException("Invalid petId!");
		}
		return dao.removePet(petId);
		
	}
	public List<Pet> findAll() throws SQLException {
		return dao.petAvailableForAdoption();
	}

}
