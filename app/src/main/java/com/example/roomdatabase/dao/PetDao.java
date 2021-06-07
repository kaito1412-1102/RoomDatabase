package com.example.roomdatabase.dao;

import com.example.roomdatabase.model.Pet;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface PetDao {
    @Query("SELECT * FROM pet WHERE pet_owner_id = :userId")
    List<Pet> getPetUser(int userId);

    @Insert
    void insertPet(Pet pet);

    //    @Query("DELETE FROM pet WHERE pet_id = :pet_id AND pet_owner_id = :user_id")
    @Delete
    void deletePet(Pet pet);

    @Query("DELETE FROM pet WHERE pet_owner_id=:userId")
    void deleteAllPet(int userId);
}
