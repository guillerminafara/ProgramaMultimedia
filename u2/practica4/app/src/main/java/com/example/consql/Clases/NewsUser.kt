package com.example.consql.Clases


import androidx.room.Entity
import androidx.room.ForeignKey
//LIKES
@Entity(
    tableName = "FavoriteEntity",
    primaryKeys = ["userId", "noticeId"],
    foreignKeys = [
        ForeignKey(entity = UserEntity::class, parentColumns = ["id"], childColumns = ["userId"]),
        ForeignKey(entity = NewsEntity::class, parentColumns = ["id"], childColumns = ["noticeId"])
    ]
)
data class FavoriteEntity(
    val userId: Int,
    val noticeId: Int
)
