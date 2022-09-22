package com.adelvanchik.quickmath.presentation

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adelvanchik.domain.models.ExpressionWithResult
import com.adelvanchik.domain.usecases.GeneratorExpressionUseCase
import com.adelvanchik.domain.usecases.betterResult.GetDataUseCase
import com.adelvanchik.domain.usecases.expressionHundreds.GetRandomExpressionAdditionHundredsUseCase
import com.adelvanchik.domain.usecases.expressionHundreds.GetRandomExpressionSubtractionHundredsUseCase
import com.adelvanchik.domain.usecases.expressionSimple.GetRandomExpressionAdditionSimpleUseCase
import com.adelvanchik.domain.usecases.expressionSimple.GetRandomExpressionSubtractionSimpleUseCase
import com.adelvanchik.domain.usecases.multiplicationTable.GetRandomExpressionMultiplicationTableDivisionUseCase
import com.adelvanchik.domain.usecases.multiplicationTable.GetRandomExpressionMultiplicationTableUseCase

class StartingViewModel(private val generatorExpressionUseCase: GeneratorExpressionUseCase,
                        private val getDataUseCase: GetDataUseCase): ViewModel() {

    init {

    }

    fun start(mode: String, isTime: String) {
        first_load.value = true
        sound.value = getDataUseCase.execute("sound")
        soundClick.value = getDataUseCase.execute("soundClick").toInt()
        myMode = mode
        myIsTime = isTime
        if (myIsTime.equals("yes")) timerDown = timerDownFirstValue()
        correct_result.value = "-1"
        time_out.value = false
        Log.e("SVM","Первый старт")
        createExpression()
    }

    // Создание примера
    fun createExpression() {
        lvl_int++
        lvl.value = lvl_int
        Log.e("SVM","Подготовка примера")
        var generatorExpressionRamdom: ExpressionWithResult = generatorExpressionUseCase.execute(myMode)
         if (myMode.contains("Negative")) {
            if (generatorExpressionRamdom.secondNumber<0) {
                expression.value =
                    "${generatorExpressionRamdom.firstNumber} ${generatorExpressionRamdom.expression} (${generatorExpressionRamdom.secondNumber})"
            } else {
                expression.value =
                    "${generatorExpressionRamdom.firstNumber} ${generatorExpressionRamdom.expression} ${generatorExpressionRamdom.secondNumber}"
            }
        } else {
             expression.value = generatorExpressionRamdom.expression.toString()
         }

        correct_result.value = generatorExpressionRamdom.result.toString()


    }


    // переменные
    private var timer: CountDownTimer? = null       // Таймер
    private var myMode: String = ""                 // Выбранный режим
    private var myIsTime: String = "yes"            // Выбранный режим (время)
    private var timerDown: Long = 0                 // Сколько миллесекунд на первом уровне
    private var lvl_int: Int = 0                    // Уровень

    //LiveData
    private val expression = MutableLiveData<String>()          // Привер в строке
    private val answer = MutableLiveData<String>()              // Ответ пользователся в строке
    private val correct_result = MutableLiveData<String>()      // Правильный ответ на пример
    private val lvl = MutableLiveData<Int>()                    // Текущий уровень
    private val timer_data = MutableLiveData<Long>()            // Таймер
    private val first_load = MutableLiveData<Boolean>()         // Отсчитался ли первый таймер
    private val time_out = MutableLiveData<Boolean>()           // Закончилось ли время
    private val sound = MutableLiveData<String>()               // Режим звука (включен/выключен)
    private val soundClick = MutableLiveData<Int>()               // Режим звука тыканья по кнопкам



    // Получение LiveData во фрагменте
    fun getSound(): MutableLiveData<String> {
        return sound
    }

    fun getSoundClick(): MutableLiveData<Int> {
        return soundClick
    }

    fun getExpression(): MutableLiveData<String> {
        return expression
    }

    fun getAnswer(): MutableLiveData<String> {
        return answer
    }

    fun getCorrectResult(): MutableLiveData<String> {
        return correct_result
    }

    fun getLvl(): MutableLiveData<Int> {
        return lvl
    }

    fun getTimerData(): MutableLiveData<Long> {
        return timer_data
    }

    fun getTimeOut(): MutableLiveData<Boolean> {
        return time_out
    }

    fun getFirst_load(): MutableLiveData<Boolean> {
        return first_load
    }



    // Обнуление LiveData после перехода с фрагмента на другой
    fun DefaultAnswer() {
        Log.e("SVM","Сброс ответа")
        answer.value = ""
    }
    fun Default_Expression() {
        expression.value = ""
    }
    fun DefaultLvl() {
        lvl_int = 0
    }

    fun DefaultFirstLoad() {
        first_load.value = false
    }

    fun DefaultTimerDown() {
        timer_data.value = 0
        timerDown = timerDownFirstValue()
    }


    // Функция ввода
    fun Input_answer(figure: String) {
        var result: String
        if (answer.value!= null && !figure.equals("-")) {
            if (answer.value!!.length != 3) {
                result = answer.value + "$figure"
                answer.value = result
            }
        } else if ((answer.value== null ||  answer.value == "" ) && figure.equals("-")) {
            result = "$figure"
            answer.value = result
        }
        else if (!figure.equals("-")){
            result = "$figure"
            answer.value = result
        }
    }

    // Функция удаления последнего элемента в ответе
    fun delete() {
        var result: String = ""
        if (answer.value!= null) {
            result = answer.value!!.dropLast(1)
        }
        answer.value = result
    }


    // Функция проверки ответа
    fun Check_answer(): Boolean {
        Log.e("CheckAnswer","Правильынй ответ: ${correct_result.value}, попытка: ${answer.value}")
        timer?.cancel()
        if (first_load.value == false) {
            first_load.value = true
        }
        Log.e("SVM","Проверка начианается")
        if ((answer.value) == (correct_result.value)) {
            Log.e("SVM","Ответ верный")
            if (myIsTime.equals("yes")) timerDownValue()
            DefaultAnswer()
            if (myIsTime.equals("yes")) TimerForExpression(timerDown)
            return true
        } else {
            Log.e("SVM","Ответ неверный")
            lvl_int = 0
            return false
        }
    }

    // Таймер для решения примера
    private fun TimerForExpression(timeInMillis: Long) {
        timer = object: CountDownTimer(timeInMillis, 1) {
            override fun onTick(timeM: Long) {
                timer_data.value = timeM
            }
            override fun onFinish() {
                time_out.value = true
                timer?.cancel()
            }
        }.start()
    }

    private fun timerDownValue() {
        when (myMode) {
            "HundredsAdditionSubtraction" -> {
                if (timerDown>=30000) timerDown-= 2000
                else if (timerDown > 15000) timerDown-= 1000
                else if (timerDown > 10000) timerDown-=200
                else if (timerDown > 2000) timerDown-=20
            }
            "SimpleAdditionSubtraction" -> {
                if (timerDown>=10000) timerDown-= 1000
                else if (timerDown > 10000) timerDown-= 300
                else if (timerDown > 5000) timerDown-=200
                else if (timerDown > 2000) timerDown-=150
                else if (timerDown > 2000) timerDown-=50
                else if (timerDown > 500) timerDown-=20
            }
            "MultiplicationTable" -> {
                if (timerDown>= 2000) timerDown-= 200
                else if (timerDown > 1000) timerDown-=50
                else if (timerDown > 500) timerDown-=20
            }
            "MultiplicationDivision" -> {
                if (timerDown >= 2000) timerDown -= 200
                else if (timerDown > 1000) timerDown -= 50
                else if (timerDown > 500) timerDown -= 20
            }
            "NegativeAdditionSubtraction" -> {
                if (timerDown>= 10000) timerDown-= 500
                else if (timerDown > 2000) timerDown-=100
            }
            "NegativeMultiplicationDiivision" -> {
                if (timerDown>= 10000) timerDown-= 500
                else if (timerDown > 2000) timerDown-=100
            }
            "NegativeMixed" -> {
                if (timerDown>= 10000) timerDown-= 500
                else if (timerDown > 2000) timerDown-=100
            }
            else -> {
                if (timerDown>= 2000) timerDown-= 200
                else if (timerDown > 1000) timerDown-=50
                else if (timerDown > 500) timerDown-=20
            }
        }
    }

    private fun timerDownFirstValue(): Long {
        when (myMode) {
            "HundredsAdditionSubtraction" -> {
               return  59000
            }
            "SimpleAdditionSubtraction" -> {
               return 30000
            }
            "MultiplicationTable" -> {
               return 10000
            }
            "MultiplicationDivision" -> {
                return 10000
            }
            "NegativeAdditionSubtraction" -> {
                return  20000
            }
            "NegativeMultiplicationDiivision" -> {
                return  20000
            }
            "NegativeMixed" -> {
                return  20000
            }
            else -> return 10000
        }
    }

}
