package com.example.consql.consultas

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.consql.Clases.NewsEntity


@Dao
interface NewsDao {
    @Query("SELECT * FROM EntityNotice LIMIT 10")
    suspend fun getAllNotice(): MutableList<NewsEntity>
    @Insert
    suspend fun addNotice(entityNotice: NewsEntity): Long
    @Update
    suspend fun updateNotice(entityNotice: NewsEntity)
    @Delete
    suspend fun deleteNotice(entityNotice: NewsEntity)
}