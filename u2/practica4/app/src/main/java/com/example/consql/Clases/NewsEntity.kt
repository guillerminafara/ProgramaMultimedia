package com.example.consql.Clases

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "EntityNotice",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["id"],
        childColumns = ["idUser"],
        onDelete = ForeignKey.CASCADE
    )],
     indices = [Index(value = ["idUser"])]
)

class NewsEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var titulo: String = "",
    var resumen: String = "",
    var fecha: String = "",
    var imagen: String = "",
    var enlace: String = "",
    var idUser: Int
)




