package com.adelvanchik.domain.usecases

import com.adelvanchik.domain.models.ExpressionWithResult

class RandomExpression() {
    fun execute(first: Int, last: Int, params: String): ExpressionWithResult{
        var firstNumber: Int = 0
        var secondNumber: Int = 0
        var result: Int = 0
        var firstSign: Int = 1
        var secondSign: Int = 1
        when(params) {
            "+" -> {
                firstNumber = (first..last-1).random()
                secondNumber = (first..(last - firstNumber)).random()
                result = firstNumber + secondNumber

            }
            "-" -> {
                firstNumber = (first..last).random()
                secondNumber = (first..firstNumber).random()
                result = firstNumber - secondNumber
            }
            "*" -> {
                firstNumber = (first..last).random()
                secondNumber = (first..last).random()
                result = firstNumber * secondNumber
            }
            "/" -> {
                firstNumber = (first..last).random()
                secondNumber = (first..last).random()
                result = firstNumber
                firstNumber *= secondNumber
            }
            "-*" -> {
                val randomSign = (1..2).random()
                if (randomSign==1) firstSign = -1
                else firstSign = 1

                val randomSign2 = (1..2).random()
                if (randomSign2==1) secondSign = -1
                else secondSign = 1

                firstNumber = (first..last).random() * firstSign
                secondNumber = (first..last).random() * secondSign
                result = firstNumber * secondNumber
            }
            "-/" -> {
                val randomSign = (1..2).random()
                if (randomSign==1) firstSign = -1
                else firstSign = 1

                val randomSign2 = (1..2).random()
                if (randomSign2==1) secondSign = -1
                else secondSign = 1

                firstNumber = (first..last).random() * firstSign
                secondNumber = (first..last).random() * secondSign
                result = firstNumber
                firstNumber *= secondNumber
            }
            "-+" -> {
                firstNumber = (first..last).random()
                secondNumber = (first..last).random()
                result = firstNumber + secondNumber

            }
            "--" -> {
                firstNumber = (first..last).random()
                secondNumber = (first..last).random()
                result = firstNumber - secondNumber
            }
        }

        return ExpressionWithResult(firstNumber = firstNumber,
                                    secondNumber = secondNumber,
                                    result = result,
                                    expression = "")
    }
}