package com.example.onlineshop.database

import com.example.onlineshop.database.Dao.AccountDao
import com.example.onlineshop.datamodels.items.AccountData
import com.example.onlineshop.datamodels.items.toAccountEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.invoke
import kotlinx.coroutines.withContext

class AccountRepository(private val accountDao: AccountDao) {
    suspend fun insertAccount(item: AccountData) {
        Dispatchers.IO {
            accountDao.insertItem(item.toAccountEntity())
        }
    }

    suspend fun isAccountBusy(account: AccountData): Boolean {
        return withContext(Dispatchers.IO) {
            accountDao.isAccountBusy(account.firstName, account.lastName, account.email)
        }
    }

    suspend fun isAccountExist(account: AccountData): Boolean {
        return withContext(Dispatchers.IO) {
            accountDao.isAccountExist(account.firstName, account.lastName)
        }
    }

}