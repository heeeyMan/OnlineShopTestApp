package com.example.onlineshop.database.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.onlineshop.database.Entities.AccountEntity

@Dao
interface AccountDao {
    @Insert(entity = AccountEntity::class)
    suspend fun insertItem(item: AccountEntity)

    @Query(
        "SELECT EXISTS (SELECT 1 FROM accounts " +
                "WHERE firstName IN (:firstName) AND lastName IN (:lastName) AND email IN (:email))"
    )
    fun isAccountBusy(
        firstName: String, lastName: String, email: String
    ): Boolean

    @Query(
        "SELECT EXISTS (SELECT 1 FROM accounts " +
                "WHERE firstName IN (:firstName) )"
    )
    fun isAccountExist(
        firstName: String
    ): Boolean
}
