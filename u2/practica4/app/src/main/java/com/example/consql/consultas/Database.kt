package com.example.consql.consultas

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.consql.Clases.FavoriteEntity
import com.example.consql.Clases.NoticeEntity
import com.example.consql.Clases.UserEntity

@Database (entities = [UserEntity::class,NoticeEntity::class,FavoriteEntity::class], version = 1)
abstract class Database:RoomDatabase (){
    abstract fun userDao():UserDAO
    abstract fun noticeDao():NoticeDao
    abstract fun noticeUserDao():NoticeUserDAO
}