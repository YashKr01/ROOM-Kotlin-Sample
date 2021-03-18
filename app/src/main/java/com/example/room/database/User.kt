package com.example.room.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "db")
data class User(
    val name: String, val email: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
) {
}