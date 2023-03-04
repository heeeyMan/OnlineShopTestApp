package com.example.testapp.ui.modules.signin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.datamodels.enums.CurrentPage
import com.example.testapp.datamodels.items.AccountData
import com.example.testapp.models.signin.ISignInModel
import com.example.testapp.routers.signin.ISignInRouter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignInViewModel(
    private val model: ISignInModel,
    private val router: ISignInRouter
) : ViewModel() {
    val currentScreen = MutableLiveData<CurrentPage>()

    fun updateScreen(current: CurrentPage) {
        currentScreen.postValue(current)
    }
    fun checkAccountAvailability(): CurrentPage {
        val account = viewModelScope.launch {
            withContext(Dispatchers.IO) {

            }
        }
        return CurrentPage.SIGN_IN
    }
    fun createAccount(account: AccountData) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

            }
        }
    }
}