package com.example.onlineshop.ui.modules.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshop.datamodels.enums.ProfileItemType
import com.example.onlineshop.models.profile.IProfileModel
import com.example.onlineshop.routers.profile.IProfileRouter
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val model: IProfileModel,
    private val router: IProfileRouter
) : ViewModel() {
    val profileItems = MutableLiveData<List<Item>>()
    val fullName = MutableLiveData<String>()
    fun initProfileList() {
        profileItems.postValue(model.getProfileList())
        setFullName()
    }

    private fun setFullName() {
        viewModelScope.launch {
            fullName.postValue(model.getFullName())
        }
    }

    fun handleClick(item: ProfileItemType) {
        when (item) {
            ProfileItemType.LOG_OUT -> router.backAuthScreen()
            else -> {}
        }
    }
}