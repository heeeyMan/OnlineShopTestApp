package com.example.testapp.ui.modules.auth

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.R
import com.example.testapp.datamodels.enums.AccountState
import com.example.testapp.datamodels.enums.CurrentPage
import com.example.testapp.datamodels.enums.FieldType
import com.example.testapp.datamodels.enums.InputTextState
import com.example.testapp.datamodels.items.AccountData
import com.example.testapp.models.auth.IAuthModel
import com.example.testapp.routers.auth.IAuthRouter
import com.example.testapp.utils.EMPTY_STRING
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthViewModel(
    private val model: IAuthModel,
    private val router: IAuthRouter
) : ViewModel() {
    val currentScreen = MutableLiveData<CurrentPage>()
    val accountState = MutableLiveData<AccountState>()
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
            CurrentPage.SIGN_IN -> CurrentPage.LOG_IN
            CurrentPage.LOG_IN -> CurrentPage.SIGN_IN
        }
        initScreen()
    }

    fun authButtonPressed(account: AccountData) {
        when (currentScreenState) {
            CurrentPage.SIGN_IN -> checkAccountAvailability()
            CurrentPage.LOG_IN -> createAccount(account)
        }
        router.openMainActivity()
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

    private fun checkAccountAvailability() {
        val account = viewModelScope.launch {
            withContext(Dispatchers.IO) {

            }
        }
    }

    private fun createAccount(account: AccountData) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

            }
        }
    }

    fun isClickable(): Boolean {
        return when (currentScreenState) {
            CurrentPage.LOG_IN -> firstNameState.isCorrect() &&
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