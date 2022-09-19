package com.adelvanchik.quickmath.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adelvanchik.domain.usecases.betterResult.GetDataUseCase
import com.adelvanchik.domain.usecases.betterResult.SaveDataUseCase

class SettingViewModel(private val saveDataUseCase: SaveDataUseCase,
                        private val getDataUseCase: GetDataUseCase): ViewModel() {

    private val namePerson = MutableLiveData<String>()

    fun saveNamePerson(name: String) {
        saveDataUseCase.execute(key = "namePerson", value = name)
    }


    fun soundSaveMode(soundMode: String) {
        saveDataUseCase.execute(key = "sound", value = soundMode)
    }

    private var sound = MutableLiveData<Boolean>()

    fun getSoundMode() {
        val mode: String = getDataUseCase.execute("sound")
        sound.value = !mode.equals("off")
    }

    fun getSoundLiveData(): MutableLiveData<Boolean> {
        return sound
    }


    fun soundClickSaveMode(soundClickMode: Int) {
        saveDataUseCase.execute(key = "soundClick", value = soundClickMode.toString())
    }

    private var soundClick = MutableLiveData<Int>()

    fun getSoundClickMode() {
        soundClick.value = getDataUseCase.execute("soundClick").toInt()
    }

    fun getSoundClickLiveData(): MutableLiveData<Int> {
        return soundClick
    }


    fun saveLanguage(lan: Int) {
        saveDataUseCase.execute(key = "language", value = lan.toString())
    }

    private var language = MutableLiveData<Int>()

    fun getlanguage() {
        language.value = getDataUseCase.execute("language").toInt()
    }

    fun getlanguageLiveData(): MutableLiveData<Int> {
        return language
    }

}