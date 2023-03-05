package com.example.testapp.database

import com.example.testapp.database.Dao.AccountDao
import com.example.testapp.datamodels.items.AccountData
import com.example.testapp.datamodels.items.toAccountEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke

class AccountRepository(private val accountDao: AccountDao) {
    suspend fun insertAccount(item: AccountData) {
        Dispatchers.IO {
            accountDao.insertItem(item.toAccountEntity())
        }
    }

    /*suspend fun isExist(account: AccountData): Boolean {
        return withContext(Dispatchers.IO) {
            accountDao.isExists(account)
        }
    }*/
}