package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.model.Cat;
import com.model.Dog;
import com.model.Pet;
import com.utility.DBConnection;

public class ShelterDaoImpl implements ShelterDao{

	@Override
	public List<Pet> petAvailableForAdoption() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM pet WHERE available_for_adoption = 1";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Pet> list = new ArrayList<Pet>();
		while (rst.next() == true) {// pet_id | pet_name | pet_type | age  | breed    | colour | shelter_id | available_for_adoption | event_id
			int petId = rst.getInt("pet_id");
			String petName = rst.getString("pet_name");
			String type = rst.getString("pet_type");
			int age = rst.getInt("age");
			String breed = rst.getString("breed");
			String colour= rst.getString("colour");
			int shelterId = rst.getInt("shelter_id");
			String availableForAdoption = rst.getString("available_for_adoption");
			int eventId = rst.getInt("event_id");

			Pet pet = new Pet(petId, petName, type, age, shelterId,availableForAdoption,eventId);
			Cat cat = new Cat(colour);
			Dog dog = new Dog(breed);
			list.add(pet);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public int removePet(int petId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE pet SET isActive = 0 WHERE pet_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, petId);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public List<Pet> petAvailableForAdoptionShelter(int shelterId) throws SQLException   {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM pet p JOIN shelter s ON p.shelter_id = s.shelter_id WHERE p.available_for_adoption = 1 AND shelter_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, shelterId);
		ResultSet rst = pstmt.executeQuery();
		List<Pet> list = new ArrayList<Pet>();
		while (rst.next() == true) {// pet_id | pet_name | pet_type | age  | breed    | colour | shelter_id | available_for_adoption | event_id
			int petId = rst.getInt("pet_id");
			String petName = rst.getString("pet_name");
			String type = rst.getString("pet_type");
			int age = rst.getInt("age");
			String breed = rst.getString("breed");
			String colour= rst.getString("colour");
			int shelterid = rst.getInt("shelter_id");
			String availableForAdoption = rst.getString("available_for_adoption");
			int eventId = rst.getInt("event_id");

			Pet pet = new Pet(petId, petName, type, age, shelterid,availableForAdoption,eventId);
			Cat cat = new Cat(colour);
			Dog dog = new Dog(breed);
			list.add(pet);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public int addPet(Pet pet, Cat cat, Dog dog) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO pet(pet_id,pet_name,age,breed,pet_type,available_for_adoption,shelter_id,colour) values (?,?,?,?,?,1,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, pet.getPetId());
		pstmt.setString(2, pet.getPetName());
		pstmt.setInt(3, pet.getPetAge());
		pstmt.setString(5, pet.getPetType());
		pstmt.setInt(6, pet.getShelterId());
		pstmt.setString(7, cat.getCatColour());
		pstmt.setString(4, dog.getDogBreed());

		int status = pstmt.executeUpdate();

		DBConnection.dbClose();
		return status;
		
	}

	@Override
	public boolean findOne(int petId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM pet WHERE pet_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, petId);
		ResultSet rst = pstmt.executeQuery();
		
		if(rst.next() == true)
			return true;
		
		
		DBConnection.dbClose();
		return false;
	}

	
}
