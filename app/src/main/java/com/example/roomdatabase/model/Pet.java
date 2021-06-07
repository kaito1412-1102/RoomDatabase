package com.example.roomdatabase.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

//Bảng User với Pet là mối quan hệ 1 - nhiều
@Entity(tableName = "pet", foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "user_id", childColumns = "pet_owner_id"))
public class Pet {
    @ColumnInfo(name = "pet_id")
    @PrimaryKey(autoGenerate = true)
    private int petId;

    //dog,cat
    @ColumnInfo(name = "pet_type")
    private String petType;

    @ColumnInfo(name = "pet_name")
    private String petName;

    @ColumnInfo(name = "pet_owner_id")
    private int petOwnerId;

    public Pet(String petType, String petName, int petOwnerId) {
        this.petType = petType;
        this.petName = petName;
        this.petOwnerId = petOwnerId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetOwnerId() {
        return petOwnerId;
    }

    public void setPetOwnerId(int petOwnerId) {
        this.petOwnerId = petOwnerId;
    }
}
