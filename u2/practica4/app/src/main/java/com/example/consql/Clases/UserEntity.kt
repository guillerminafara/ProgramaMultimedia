package com.example.consql.Clases

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import androidx.room.Entity
import androidx.room.PrimaryKey
@Parcelize
@Entity(tableName = "EntityUser")
class UserEntity (@PrimaryKey(autoGenerate = true)
                  var id: Int=0,
                  var user:String="", //este podria ser clave primaria(?
                  var pass:String=""
    ) : Parcelable
