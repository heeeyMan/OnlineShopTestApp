package com.example.testapp.database.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.testapp.database.Entities.AccountEntity

@Dao
interface AccountDao {
    @Insert(entity = AccountEntity::class)
    suspend fun insertItem(item: AccountEntity)

    @Query(
        "SELECT EXISTS (SELECT 1 FROM accounts " +
                "WHERE firstName IN (:firstName) AND lastName IN (:lastName) AND email IN (:email))"
    )
    fun isExists(
        firstName: String, lastName: String, email: String
    ): Boolean
}
