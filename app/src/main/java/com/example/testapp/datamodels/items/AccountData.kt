package com.example.testapp.datamodels.items

import com.example.testapp.database.Entities.AccountEntity
import com.example.testapp.utils.ZERO

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
    email = email
)
