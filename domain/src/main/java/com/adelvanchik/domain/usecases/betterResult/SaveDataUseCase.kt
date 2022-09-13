package com.adelvanchik.domain.usecases.betterResult

import com.adelvanchik.domain.repository.Data

class SaveDataUseCase(private val data: Data) {
    fun execute(value: String, key: String): Boolean {
        val result: Boolean = data.saveData(value, key)
        return result
    }
}