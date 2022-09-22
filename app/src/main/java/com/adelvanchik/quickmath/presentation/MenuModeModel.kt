package com.adelvanchik.quickmath.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adelvanchik.domain.usecases.betterResult.GetDataUseCase

class MenuModeModel(private val getDataUseCase: GetDataUseCase): ViewModel() {

    private val lvlInfoLiveData = MutableLiveData<Int>()

    fun getLvlInfoLiveData(): MutableLiveData<Int> {
        return lvlInfoLiveData
    }

    fun getLvlInfo() {
        lvlInfoLiveData.value = getDataUseCase.execute("lvlInfoInt").toInt()
    }

}