package com.adelvanchik.quickmath.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adelvanchik.domain.usecases.betterResult.GetDataUseCase
import com.adelvanchik.domain.usecases.betterResult.SaveDataUseCase

class AchievementsViewModel(private val getDataUseCase: GetDataUseCase): ViewModel() {

    private val cup_77_expression = MutableLiveData<Boolean>()
    private val cup_777_expression = MutableLiveData<Boolean>()
    private val cup_7777_expression = MutableLiveData<Boolean>()
    private val cup_better_result_30 = MutableLiveData<Boolean>()
    private val cup_better_result_50= MutableLiveData<Boolean>()
    private val cup_better_result_100 = MutableLiveData<Boolean>()
    private val cup_all_mode = MutableLiveData<Boolean>()
    private val cup_have_5_cup = MutableLiveData<Boolean>()

    fun get_cup_77_expression(): MutableLiveData<Boolean> {
        return cup_77_expression
    }
    fun get_cup_777_expression(): MutableLiveData<Boolean> {
        return cup_777_expression
    }
    fun get_cup_7777_expression(): MutableLiveData<Boolean> {
        return cup_7777_expression
    }
    fun get_cup_better_result_30(): MutableLiveData<Boolean> {
        return cup_better_result_30
    }
    fun get_cup_better_result_50(): MutableLiveData<Boolean> {
        return cup_better_result_50
    }
    fun get_cup_better_result_100(): MutableLiveData<Boolean> {
        return cup_better_result_100
    }
    fun get_cup_all_mode(): MutableLiveData<Boolean> {
        return cup_all_mode
    }
    fun get_cup_have_5_cup(): MutableLiveData<Boolean> {
        return cup_have_5_cup
    }


    fun check_cup() {
        val Check_cup_77_expression: Int = getDataUseCase.execute("cup_77_expression").toInt()
        val Check_cup_777_expression: Int = getDataUseCase.execute("cup_777_expression").toInt()
        val Check_cup_7777_expression: Int = getDataUseCase.execute("cup_7777_expression").toInt()
        val Check_cup_30_better_result: Int = getDataUseCase.execute("cup_30_better_result").toInt()
        val Check_cup_50_better_result: Int = getDataUseCase.execute("cup_50_better_result").toInt()
        val Check_cup_100_better_result: Int = getDataUseCase.execute("cup_100_better_result").toInt()
        val Check_cup_all_mode: Int = getDataUseCase.execute("cup_all_mode").toInt()
        val Check_cup_5_have_cup: Int = getDataUseCase.execute("cup_5_have_cup").toInt()

        if (Check_cup_77_expression!=0) {
            cup_77_expression.value = true
        }
        if (Check_cup_777_expression!=0) {
            cup_777_expression.value = true
        }
        if (Check_cup_7777_expression!=0) {
            cup_7777_expression.value = true
        }
        if (Check_cup_30_better_result!=0) {
            cup_better_result_30.value = true
        }
        if (Check_cup_50_better_result!=0) {
            cup_better_result_50.value = true
        }
        if (Check_cup_100_better_result!=0) {
            cup_better_result_100.value = true
        }
        if (Check_cup_all_mode!=0) {
            cup_all_mode.value = true
        }
        if (Check_cup_5_have_cup!=0) {
            cup_have_5_cup.value = true
        }


    }

}