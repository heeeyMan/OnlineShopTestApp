package com.example.onlineshop.ui.modules.auth

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.R
import com.example.onlineshop.datamodels.enums.*
import com.example.onlineshop.datamodels.items.AccountData
import com.example.onlineshop.models.auth.IAuthModel
import com.example.onlineshop.routers.auth.IAuthRouter
import com.example.onlineshop.utils.EMPTY_STRING
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class AuthViewModel(
    private val model: IAuthModel,
    private val router: IAuthRouter
) : ViewModel() {
    val currentScreen = MutableLiveData<CurrentPage>()
    val accountState = MutableLiveData<AccountState>()
    val dataBaseResponse = MutableLiveData<DataBaseResponse>()
    val textState = MutableLiveData<Pair<InputTextState, FieldType>>()
    private var currentScreenState = CurrentPage.SIGN_IN

    private var firstNameState = InputTextState.EMPTY
    private var lastNameState = InputTextState.EMPTY
    private var emailState = InputTextState.EMPTY

    fun initScreen() {
        currentScreen.postValue(currentScreenState)
    }

    fun changeCurrentScreen() {
        currentScreenState = when (currentScreenState) {
            CurrentPage.SIGN_IN -> CurrentPage.LOGIN
            CurrentPage.LOGIN -> CurrentPage.SIGN_IN
        }
        initScreen()
    }

    fun authButtonPressed(account: AccountData) {
        when (currentScreenState) {
            CurrentPage.LOGIN -> handleAccountState(account)
            CurrentPage.SIGN_IN -> createAccount(account)
        }
    }

    fun handleEmailText(text: String, fieldType: FieldType) {
        when {
            fieldType == FieldType.EMAIL && !Patterns.EMAIL_ADDRESS.matcher(text).matches() -> {
                textState.postValue(Pair(InputTextState.INCORRECT_EMAIL, fieldType))
                updateTextState(fieldType, InputTextState.INCORRECT_EMAIL)
            }

            text == EMPTY_STRING || text.isEmpty() -> {
                updateTextState(fieldType, InputTextState.EMPTY)
                textState.postValue(Pair(InputTextState.EMPTY, fieldType))
            }
            else -> {
                updateTextState(fieldType, InputTextState.CORRECT)
                textState.postValue(Pair(InputTextState.CORRECT, fieldType))
            }
        }
    }

    private fun getAccountState(account: AccountData): AccountState {
        return runBlocking {
            model.getAccountState(account, currentScreenState)
        }
    }

    private fun handleAccountState(account: AccountData) {
        try {
            val state = getAccountState(account)
            if (state == AccountState.ACCOUNT_EXIST) {
                router.openMainActivity()
            }
            accountState.postValue(state)
        } catch (_: Throwable) {
            dataBaseResponse.postValue(DataBaseResponse.DATA_BASE_ERROR)
        }
    }

    private fun createAccount(account: AccountData) {
        val state = getAccountState(account)
        viewModelScope.launch {
            try {
                if (state == AccountState.ACCOUNT_NOT_BUSY) {
                    model.addAccount(account)
                    withContext(Dispatchers.Main) {
                        router.openMainActivity()
                    }
                }
                accountState.postValue(state)
            } catch (_: Throwable) {
                dataBaseResponse.postValue(DataBaseResponse.DATA_BASE_ERROR)
            }
        }
    }

    fun isClickable(): Boolean {
        return when (currentScreenState) {
            CurrentPage.LOGIN -> firstNameState.isCorrect() &&
                    lastNameState.isCorrect()

            CurrentPage.SIGN_IN -> firstNameState.isCorrect() &&
                    lastNameState.isCorrect() &&
                    emailState.isCorrect()
        }
    }

    fun authButtonBackgroundId(): Int {
        return if (isClickable())
            R.drawable.auth_button_state
        else
            R.drawable.auth_button_blocked
    }

    private fun updateTextState(fieldType: FieldType, state: InputTextState) {
        when (fieldType) {
            FieldType.FIRST_NAME -> firstNameState = state
            FieldType.LAST_NAME -> lastNameState = state
            FieldType.EMAIL -> emailState = state
        }
    }

    fun getCurrentScreenState() = currentScreenState
}