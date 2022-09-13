package com.adelvanchik.domain.usecases.betterResult

import com.adelvanchik.domain.repository.Data


class GetDataUseCase(private val data: Data) {
    fun execute(key: String): String {
        return data.getData(key)
    }
}