package com.example.onlineshop.database.Entities

import androidx.room.*

@Entity(
    tableName = "accounts"
)
data class AccountEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "firstName") val firstName: String,
    @ColumnInfo(name = "lastName") val lastName: String,
    @ColumnInfo(name = "email") val email: String,
)
