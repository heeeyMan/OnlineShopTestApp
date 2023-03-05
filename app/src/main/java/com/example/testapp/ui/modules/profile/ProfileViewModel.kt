package com.example.testapp.ui.modules.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.datamodels.enums.ProfileItemType
import com.example.testapp.models.profile.IProfileModel
import com.example.testapp.routers.profile.IProfileRouter
import com.xwray.groupie.kotlinandroidextensions.Item

class ProfileViewModel(
    private val model: IProfileModel,
    private val router: IProfileRouter
) : ViewModel() {
    val profileItems = MutableLiveData<List<Item>>()

    fun initProfileList() {
        profileItems.postValue(model.getProfileList())
    }

    fun handleClick(item: ProfileItemType) {
        when(item) {
            ProfileItemType.LOG_OUT -> router.backAuthScreen()
            else -> {}
        }
    }
}