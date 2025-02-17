package com.example.consql.consultas

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.consql.Clases.FavoriteEntity
import com.example.consql.Clases.NewsEntity
import com.example.consql.Clases.UserEntity

@Database (entities = [UserEntity::class,NewsEntity::class,FavoriteEntity::class], version = 2)
abstract class Database:RoomDatabase (){
    abstract fun userDao():UserDAO
    abstract fun newsDao():NewsDao
    abstract fun newsUserDao():NewsUserDAO
}