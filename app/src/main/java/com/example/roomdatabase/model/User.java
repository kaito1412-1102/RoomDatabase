package com.example.roomdatabase.model;

import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User implements Serializable {
    @ColumnInfo(name = "user_id")
    @PrimaryKey(autoGenerate = true)
    private int userId;
    @ColumnInfo(name = "user_name")
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
