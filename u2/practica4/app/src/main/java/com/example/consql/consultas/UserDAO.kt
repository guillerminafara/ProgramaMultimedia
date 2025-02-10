package com.example.consql.consultas

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.consql.Clases.UserEntity


@Dao
interface UserDAO {
    @Query("SELECT * FROM EntityUser")
    suspend fun getAllStores(): MutableList<UserEntity>
    @Insert
    suspend fun addUser(userEntity: UserEntity)
    @Update
    suspend fun updateUser(userEntity: UserEntity)
    @Delete
    suspend fun deleteUser(userEntity: UserEntity)
}