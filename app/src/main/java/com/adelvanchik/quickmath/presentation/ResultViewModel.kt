package com.adelvanchik.quickmath.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adelvanchik.domain.usecases.betterResult.GetDataUseCase
import com.adelvanchik.domain.usecases.betterResult.SaveDataUseCase
import android.R
import android.content.res.Resources
import android.provider.Settings.Global.getString
import androidx.core.content.ContentProviderCompat.requireContext


class ResultViewModel(private val saveDataUseCase: SaveDataUseCase,
                      private val getDataUseCase: GetDataUseCase): ViewModel() {

    private val betterResult = MutableLiveData<Int>()
    private val iq = MutableLiveData<Int>()
    private val betterResultBoolean = MutableLiveData<Boolean>()
    private val newLvl = MutableLiveData<Boolean>()
    private val rateNow = MutableLiveData<String>()

    fun getBetterResult(): MutableLiveData<Int> {
        return betterResult
    }

    fun getNewLvl(): MutableLiveData<Boolean> {
        return newLvl
    }

    fun getRateNow(): MutableLiveData<String> {
        return rateNow
    }

    fun better_result(lvl: Int, mode: String, isTime: String) {
        Log.e("RVM","Запуск проверки лучшего результата")
        betterResultBoolean.value = false
        val lastBetterResult: Int = getDataUseCase.execute("${mode}_${isTime}").toInt()
        val lastBetterResultGame: Int = getDataUseCase.execute("betterResultGame").toInt()

        Log.e("RVM","Получен последний лучший резльтат")
        if (lvl > lastBetterResult) {
            Log.e("RVM","Текущий результат оказался лучше предыдущего результата")
            betterResultBoolean.value = true
            saveDataUseCase.execute(value = lvl.toString(), key =  "${mode}_${isTime}")
            betterResult.value = lvl
        } else {
            Log.e("RVM","Рекордный результат не побит")
            betterResult.value = lastBetterResult
        }

        Log.e("RVM","Получен последний лучший резльтат игры")
        if (lvl > lastBetterResultGame) {
            Log.e("RVM","Текущий результат оказался лучше предыдущего результата")
            saveDataUseCase.execute(value = lvl.toString(), key =  "betterResultGame")
        }
    }

    fun addRate(nowResult: Int, lvl: Int) {
        newLvl.value = false

        val rate: Int = getDataUseCase.execute(key = "rate").toInt()
        val result: Int = rate + nowResult
        saveDataUseCase.execute(value = result.toString(), key = "rate")
        rateNow.value = "$result"

        val expressionCounter: Int = getDataUseCase.execute(key = "expressionCounter").toInt()
        val resultExpressionCounter: Int = expressionCounter + lvl
        saveDataUseCase.execute(value = resultExpressionCounter.toString(), key = "expressionCounter")
    }

    private val cup = MutableLiveData<Boolean>()

    fun getCup(): MutableLiveData<Boolean> {
        return cup
    }



    fun check_cup() {
        val all_expressions = getDataUseCase.execute(key = "expressionCounter").toInt()
        val betterResultGame = getDataUseCase.execute(key = "betterResultGame").toInt()
        val getDataCupCount = getDataUseCase.execute(key = "countCup").toInt()

        val HAS_time = getDataUseCase.execute(key = "HundredsAdditionSubtraction_yes").toInt()
        val SAS_time = getDataUseCase.execute(key = "SimpleAdditionSubtraction_yes").toInt()
        val MT_time = getDataUseCase.execute(key = "MultiplicationTable_yes").toInt()
        val MD_time = getDataUseCase.execute(key = "MultiplicationDivision_yes").toInt()
        val NAS_time = getDataUseCase.execute(key = "NegativeAdditionSubtraction_yes").toInt()
        val NMD_time = getDataUseCase.execute(key = "NegativeMultiplicationDivision_yes").toInt()
        val NM_time = getDataUseCase.execute(key = "NegativeMixed_yes").toInt()


        val NAS_train = getDataUseCase.execute(key = "NegativeAdditionSubtraction_no").toInt()
        val NMD_train = getDataUseCase.execute(key = "NegativeMultiplicationDivision_no").toInt()
        val NM_train = getDataUseCase.execute(key = "NegativeMixed_no").toInt()
        val HAS_train = getDataUseCase.execute(key = "HundredsAdditionSubtraction_no").toInt()
        val SAS_train = getDataUseCase.execute(key = "SimpleAdditionSubtraction_no").toInt()
        val MT_train = getDataUseCase.execute(key = "MultiplicationTable_no").toInt()
        val MD_train = getDataUseCase.execute(key = "MultiplicationDivision_no").toInt()
        val mixed_train = getDataUseCase.execute(key = "mixed_no").toInt()

        var countCup: Int = 0

        if (all_expressions >= 77) {
            Log.e("RVM","Решено больше 77 примеров")
            saveDataUseCase.execute(value = "1", key = "cup_77_expression")
            countCup++
        }
        if (all_expressions >= 777) {
            Log.e("RVM","Решено больше 777 примеров")
            saveDataUseCase.execute(value = "1", key = "cup_777_expression")
            countCup++
        }
        if (all_expressions >= 7777) {
            Log.e("RVM","Решено больше 7777 примеров")
            saveDataUseCase.execute(value = "1", key = "cup_7777_expression")
            countCup++
        }
        if (betterResultGame >= 30) {
            Log.e("RVM","Лучший результат больше 30")
            saveDataUseCase.execute(value = "1", key = "cup_30_better_result")
            countCup++
        }
        if (betterResultGame >= 50) {
            Log.e("RVM","Лучший результат больше 50")
            saveDataUseCase.execute(value = "1", key = "cup_50_better_result")
            countCup++
        }
        if (betterResultGame >= 100) {
            Log.e("RVM","Лучший результат больше 100")
            saveDataUseCase.execute(value = "1", key = "cup_100_better_result")
            countCup++
        }

        if(HAS_train>0 && HAS_time>0 && SAS_train>0 && SAS_time>0
            && MT_train>0 && MT_time>0 && MD_train>0 && MD_time>0 && mixed_train>0
            && NAS_time>0 && NAS_train>0 && NMD_time>0 && NMD_train>0 && NM_time>0
            && NM_train>0)    {
            Log.e("RVM","Испробованы все режимы")
            saveDataUseCase.execute(value = "1", key = "cup_all_mode")
            countCup++
        }
        if (countCup>=5) {
            Log.e("RVM","Больше 5 кубков")
            saveDataUseCase.execute(value = "1", key = "cup_5_have_cup")
            countCup++

        }

        if (countCup > getDataCupCount) {
            Log.e("RVM","Получен новый кубок")
            cup.value = true
        }
        saveDataUseCase.execute(value = countCup.toString(), key = "countCup")

    }

    fun checkNewLvl(MaybeNewLvl: String) {
        val lvlInfo: String = getDataUseCase.execute(key = "lvlInfo")
        if (!lvlInfo.equals(MaybeNewLvl)) {
            newLvl.value = true
        }
        saveDataUseCase.execute(key = "lvlInfo", value = MaybeNewLvl)
    }

}