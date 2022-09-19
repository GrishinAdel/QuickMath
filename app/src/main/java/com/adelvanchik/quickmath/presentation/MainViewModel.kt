package com.adelvanchik.quickmath.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adelvanchik.domain.usecases.betterResult.GetDataUseCase
import com.adelvanchik.domain.usecases.expressionHundreds.GetRandomExpressionSubtractionHundredsUseCase
import com.adelvanchik.domain.usecases.expressionSimple.GetRandomExpressionAdditionSimpleUseCase
import com.adelvanchik.domain.usecases.expressionSimple.GetRandomExpressionSubtractionSimpleUseCase

class MainViewModel(private val getDataUseCase: GetDataUseCase): ViewModel() {

    private val namePerson = MutableLiveData<String>()
    fun get_namePerson(): MutableLiveData<String> {
        return namePerson
    }

    fun getName() {
        namePerson.value = getDataUseCase.execute(key = "namePerson")
    }
}