package com.example.consql.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.test.espresso.core.internal.deps.dagger.Module
import androidx.test.espresso.core.internal.deps.dagger.Provides
import com.example.consql.Clases.NoticeEntity
import com.example.consql.consultas.Database

import javax.inject.Singleton


class NoticeRoom:Application(){

    companion object{
        lateinit var database: Database
    }

    override fun onCreate() {
        super.onCreate()
        database=Room.databaseBuilder(this,
            Database::class.java,
            "Database")
                .build()
    }
}

//@Module
//@InstallIn(SingletonComponent::clas)
//object RoomModule {
//    const val DATABASE_NAME="noticeDatabase"
//    @Singleton
//    @Provides
//    fun provideRoom(@ApplicationContext context: Context)=
//        Room.databaseBuilder(context, NoticeEntity::class.java,DATABASE_NAME ).build()
//
//    @Singleton
//    @Provides
//   // fun providesNoticeDao(db: Database)=db.noticeDao()
//}
