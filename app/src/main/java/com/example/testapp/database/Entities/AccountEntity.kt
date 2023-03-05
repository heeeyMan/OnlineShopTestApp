package com.example.testapp.database.Entities

import androidx.room.*
import com.example.testapp.datamodels.items.AccountData

@Entity(
    tableName = "accounts"
)
data class AccountEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "firstName") val firstName: String,
    @ColumnInfo(name = "lastName") val lastName: String,
    @ColumnInfo(name = "email") val email: String
)

fun AccountEntity.toAccountData() = AccountData(
    firstName = firstName,
    lastName = lastName,
    email = email
)

//foreignKeys = [ForeignKey(
//        entity = AccountEntity::class, parentColumns = ["id"],
//        childColumns = ["first_name"])]
