package com.adelvanchik.quickmath.presentation

import androidx.lifecycle.ViewModel
import com.adelvanchik.domain.usecases.betterResult.GetDataUseCase
import com.adelvanchik.domain.usecases.expressionHundreds.GetRandomExpressionSubtractionHundredsUseCase
import com.adelvanchik.domain.usecases.expressionSimple.GetRandomExpressionAdditionSimpleUseCase
import com.adelvanchik.domain.usecases.expressionSimple.GetRandomExpressionSubtractionSimpleUseCase

class MainViewModel(private val getDataUseCase: GetDataUseCase): ViewModel() {

    fun getName() {
        val name: String = getDataUseCase.execute(key = "namePerson")
    }
}