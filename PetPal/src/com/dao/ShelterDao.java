package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Cat;
import com.model.Dog;
import com.model.Pet;

public interface ShelterDao {
	List<Pet> petAvailableForAdoption() throws SQLException;
	int removePet(int petId) throws SQLException;
	List<Pet> petAvailableForAdoptionShelter(int shelterId) throws SQLException;
	int addPet(Pet pet, Cat cat, Dog dog) throws SQLException;
	boolean findOne(int petId) throws SQLException;

}
