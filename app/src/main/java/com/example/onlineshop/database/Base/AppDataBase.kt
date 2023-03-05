package com.example.onlineshop.database.Base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.onlineshop.database.Dao.AccountDao
import com.example.onlineshop.database.Entities.AccountEntity

@Database(version = 1, entities = [AccountEntity::class])
abstract class AppDataBase : RoomDatabase() {
    abstract fun getAccountDao(): AccountDao
}