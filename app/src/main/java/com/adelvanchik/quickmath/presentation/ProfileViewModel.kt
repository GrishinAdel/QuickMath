package com.adelvanchik.quickmath.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adelvanchik.domain.usecases.betterResult.GetDataUseCase

class ProfileViewModel(private val getDataUseCase: GetDataUseCase): ViewModel() {

    private val lvlInt = MutableLiveData<Int>()
    private val lvlInfo = MutableLiveData<String>()

    fun get_lvlInt(): MutableLiveData<Int> {
        return lvlInt
    }
    fun get_lvlInfo(): MutableLiveData<String> {
        return lvlInfo
    }

    private val namePerson = MutableLiveData<String>()
    fun get_namePerson(): MutableLiveData<String> {
        return namePerson
    }

    fun info() {

        lvlInt.value = getDataUseCase.execute(key = "rate").toInt()
        lvlInfo.value = getDataUseCase.execute(key = "lvlInfo")
        namePerson.value = getDataUseCase.execute(key = "namePerson")

    }
}