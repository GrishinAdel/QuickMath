package com.adelvanchik.quickmath.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adelvanchik.domain.usecases.betterResult.GetDataUseCase

class StatViewModel(private val getDataUseCase: GetDataUseCase): ViewModel() {
    private val info_multiplication_inTime = MutableLiveData<Int>()
    private val info_multiplicationDivision_inTime = MutableLiveData<Int>()
    private val info_simpleAddition_inTime = MutableLiveData<Int>()
    private val info_hundredsAddition_inTime = MutableLiveData<Int>()
    private val info_negativeAddition_inTime = MutableLiveData<Int>()
    private val info_negativeMultiplication_inTime = MutableLiveData<Int>()
    private val info_negativeMixed_inTime = MutableLiveData<Int>()

    private val info_countExpression= MutableLiveData<Int>()
    private val info_betterResultGame= MutableLiveData<Int>()
    private val info_countCup= MutableLiveData<Int>()

    private val info_multiplication_train = MutableLiveData<Int>()
    private val info_multiplicationDivision_train = MutableLiveData<Int>()
    private val info_simpleAddition_train = MutableLiveData<Int>()
    private val info_hundredsAddition_train = MutableLiveData<Int>()
    private val info_mixedtrain = MutableLiveData<Int>()
    private val info_negativeAddition_train = MutableLiveData<Int>()
    private val info_negativeMultiplication_train = MutableLiveData<Int>()
    private val info_negativeMixed_train = MutableLiveData<Int>()


    fun get_info_multiplication_inTime(): MutableLiveData<Int> {
        return info_multiplication_inTime
    }
    fun get_info_multiplicationDivision_inTime(): MutableLiveData<Int> {
        return info_multiplicationDivision_inTime
    }
    fun get_info_simpleAddition_inTime(): MutableLiveData<Int> {
        return info_simpleAddition_inTime
    }
    fun get_info_hundredsAddition_inTime(): MutableLiveData<Int> {
        return info_hundredsAddition_inTime
    }
    fun get_info_countExpression(): MutableLiveData<Int> {
        return info_countExpression
    }
    fun get_info_betterResultGame(): MutableLiveData<Int> {
        return info_betterResultGame
    }
    fun get_info_countCup(): MutableLiveData<Int> {
        return info_countCup
    }
    fun get_info_multiplicationDivision_train(): MutableLiveData<Int> {
        return info_multiplicationDivision_train
    }
    fun get_info_multiplication_train(): MutableLiveData<Int> {
        return info_multiplication_train
    }
    fun get_info_simpleAddition_train(): MutableLiveData<Int> {
        return info_simpleAddition_train
    }
    fun get_info_hundredsAddition_train(): MutableLiveData<Int> {
        return info_hundredsAddition_train
    }
    fun get_info_mixedtrain(): MutableLiveData<Int> {
        return info_mixedtrain
    }

    fun get_info_negativeAddition_train(): MutableLiveData<Int> {
        return info_negativeAddition_train
    }
    fun get_info_negativeMultiplication_train(): MutableLiveData<Int> {
        return info_negativeMultiplication_train
    }
    fun get_info_negativeMixed_train(): MutableLiveData<Int> {
        return info_negativeMixed_train
    }
    fun get_info_negativeMixed_inTime(): MutableLiveData<Int> {
        return info_negativeMixed_inTime
    }
    fun get_info_negativeMultiplication_inTime(): MutableLiveData<Int> {
        return info_negativeMultiplication_inTime
    }
    fun get_info_negativeAddition_inTime(): MutableLiveData<Int> {
        return info_negativeAddition_inTime
    }

    fun info() {
        info_countExpression.value = getDataUseCase.execute(key = "expressionCounter").toInt()
        info_betterResultGame.value = getDataUseCase.execute(key = "betterResultGame").toInt()
        info_countCup.value = getDataUseCase.execute(key = "countCup").toInt()

        info_hundredsAddition_train.value = getDataUseCase.execute(key = "HundredsAdditionSubtraction_no").toInt()
        info_simpleAddition_train.value = getDataUseCase.execute(key = "SimpleAdditionSubtraction_no").toInt()
        info_multiplication_train.value  = getDataUseCase.execute(key = "MultiplicationTable_no").toInt()
        info_multiplicationDivision_train.value= getDataUseCase.execute(key = "MultiplicationDivision_no").toInt()
        info_negativeAddition_train.value= getDataUseCase.execute(key = "NegativeAdditionSubtraction_no").toInt()
        info_negativeMultiplication_train.value= getDataUseCase.execute(key = "NegativeMultiplicationDivision_no").toInt()
        info_negativeMixed_train.value= getDataUseCase.execute(key = "NegativeMixed_no").toInt()

        info_mixedtrain.value = getDataUseCase.execute(key = "mixed_no").toInt()

        info_hundredsAddition_inTime.value = getDataUseCase.execute(key = "HundredsAdditionSubtraction_yes").toInt()
        info_simpleAddition_inTime.value = getDataUseCase.execute(key = "SimpleAdditionSubtraction_yes").toInt()
        info_multiplication_inTime.value = getDataUseCase.execute(key = "MultiplicationTable_yes").toInt()
        info_multiplicationDivision_inTime.value= getDataUseCase.execute(key = "MultiplicationDivision_yes").toInt()
        info_negativeAddition_inTime.value= getDataUseCase.execute(key = "NegativeAdditionSubtraction_yes").toInt()
        info_negativeMultiplication_inTime.value= getDataUseCase.execute(key = "NegativeMultiplicationDivision_yes").toInt()
        info_negativeMixed_inTime.value= getDataUseCase.execute(key = "NegativeMixed_yes").toInt()

    }
}