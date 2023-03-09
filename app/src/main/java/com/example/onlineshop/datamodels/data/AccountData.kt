package com.example.onlineshop.datamodels.data

import com.example.onlineshop.database.Entities.AccountEntity
import com.example.onlineshop.utils.ZERO

data class AccountData(
    val firstName: String,
    val lastName: String,
    val email: String,
    val id: Long = ZERO.toLong()
)

fun AccountData.toAccountEntity() = AccountEntity(
    id = ZERO.toLong(),
    firstName = firstName,
    lastName = lastName,
    email = email,
)
