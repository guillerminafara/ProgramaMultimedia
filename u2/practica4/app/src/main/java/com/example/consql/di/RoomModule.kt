//package com.example.consql.di
//
//import android.app.Application
//import androidx.room.Room
//import com.example.consql.consultas.Database
//
//
//class NoticeRoom:Application(){
//
//    companion object{
//        lateinit var database: Database
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//        database=Room.databaseBuilder(this,
//            Database::class.java,
//            "Database")
//                .build()
//    }
//}

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
