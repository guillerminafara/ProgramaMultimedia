package com.example.consql.consultas

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.consql.Clases.FavoriteEntity


@Dao
interface NoticeUserDAO {
    @Query("SELECT * FROM FavoriteEntity")
    suspend fun getAllFavorite(): MutableList<FavoriteEntity>
    @Insert
    suspend fun addFavorite(favoriteEntity:FavoriteEntity )
    @Update
    suspend fun updateFavorite(favoriteEntity: FavoriteEntity)
    @Delete
    suspend fun deleteFavorite(favoriteEntity: FavoriteEntity)
}