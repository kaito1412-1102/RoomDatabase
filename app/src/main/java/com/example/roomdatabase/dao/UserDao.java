package com.example.roomdatabase.dao;

import com.example.roomdatabase.model.User;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<User> getAllUser();

    //Trả về row id => Ta có thể lấy được id của user mới được thêm do id của user là auto generate nên trong hàm khởi tạo user không có id
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertUser(User users);

    @Delete
    void deleteUser(User user);
}
