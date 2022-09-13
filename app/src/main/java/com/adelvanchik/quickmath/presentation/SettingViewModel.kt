package com.adelvanchik.quickmath.presentation

import androidx.lifecycle.ViewModel
import com.adelvanchik.domain.usecases.betterResult.SaveDataUseCase

class SettingViewModel(private val saveDataUseCase: SaveDataUseCase): ViewModel() {

    fun saveNamePerson(name: String) {
        saveDataUseCase.execute(key = "namePerson", value = name)
    }

}