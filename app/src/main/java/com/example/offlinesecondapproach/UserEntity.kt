package com.example.offlinesecondapproach

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Int,
    val userId : Int,
    val title : String,
    val body: String
)