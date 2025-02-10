package com.example.consql.consultas

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.consql.Clases.NoticeEntity


@Dao
interface NoticeDao {
    @Query("SELECT * FROM EntityNotice")
    suspend fun getAllNotice(): MutableList<NoticeEntity>
    @Insert
    suspend fun addNotice(entityNotice: NoticeEntity)
    @Update
    suspend fun updateNotice(entityNotice: NoticeEntity)
    @Delete
    suspend fun deleteNotice(entityNotice: NoticeEntity)
}