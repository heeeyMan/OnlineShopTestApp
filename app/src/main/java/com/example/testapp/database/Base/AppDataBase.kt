package com.example.testapp.database.Base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testapp.database.Dao.AccountDao
import com.example.testapp.database.Entities.AccountEntity

@Database(version = 1, entities = [AccountEntity::class])
abstract class AppDataBase : RoomDatabase() {
    abstract fun getAccountDao(): AccountDao
}