package com.example.roomdatabase.dao;

import android.content.Context;

import com.example.roomdatabase.model.Pet;
import com.example.roomdatabase.model.User;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Pet.class}, version = UserPetDatabase.DATABASE_VERSION)
public abstract class UserPetDatabase extends RoomDatabase {
    private static UserPetDatabase mDatabases;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Room_database";

    public abstract UserDao getUserDao();

    public abstract PetDao getPetDao();

    public static UserPetDatabase getInstance(Context context) {
        if (mDatabases == null) {
            mDatabases = Room.databaseBuilder(context, UserPetDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return mDatabases;
    }

}
