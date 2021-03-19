package com.example.room.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.room.database.User

@Dao
interface UserDao {

    @Query("SELECT * FROM db ORDER BY id ASC")
    fun getAllUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Delete
    suspend fun delete(user: User)

}