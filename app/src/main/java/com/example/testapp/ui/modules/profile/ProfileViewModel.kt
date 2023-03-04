package com.example.testapp.ui.modules.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.models.profile.IProfileModel
import com.xwray.groupie.kotlinandroidextensions.Item

class ProfileViewModel(
    private val model: IProfileModel
) : ViewModel() {
    val profileItems = MutableLiveData<List<Item>>()
    fun initProfileList() {
        profileItems.postValue(model.getProfileList())
    }
}