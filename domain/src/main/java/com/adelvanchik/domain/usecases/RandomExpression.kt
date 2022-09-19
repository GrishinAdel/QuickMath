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
                firstNumber = (first..last-1).shuffled().first()
                secondNumber = (first..(last - firstNumber)).shuffled().first()
                result = firstNumber + secondNumber

            }
            "-" -> {
                firstNumber = (first..last).shuffled().first()
                secondNumber = (first..firstNumber).shuffled().first()
                result = firstNumber - secondNumber
            }
            "*" -> {
                firstNumber = (first..last).shuffled().first()
                secondNumber = (first..last).shuffled().first()
                result = firstNumber * secondNumber
            }
            "/" -> {
                firstNumber = (first..last).shuffled().first()
                secondNumber = (first..last).shuffled().first()
                result = firstNumber
                firstNumber *= secondNumber
            }
            "-*" -> {
                val randomSign = (1..2).shuffled().first()
                if (randomSign==1) firstSign = -1
                else firstSign = 1

                val randomSign2 = (1..2).shuffled().first()
                if (randomSign2==1) secondSign = -1
                else secondSign = 1

                firstNumber = (first..last).shuffled().first() * firstSign
                secondNumber = (first..last).shuffled().first() * secondSign
                result = firstNumber * secondNumber
            }
            "-/" -> {
                val randomSign = (1..2).shuffled().first()
                if (randomSign==1) firstSign = -1
                else firstSign = 1

                val randomSign2 = (1..2).shuffled().first()
                if (randomSign2==1) secondSign = -1
                else secondSign = 1

                firstNumber = (first..last).shuffled().first() * firstSign
                secondNumber = (first..last).shuffled().first() * secondSign
                result = firstNumber
                firstNumber *= secondNumber
            }
            "-+" -> {
                firstNumber = (first..last).shuffled().first()
                secondNumber = (first..last).shuffled().first()
                result = firstNumber + secondNumber

            }
            "--" -> {
                firstNumber = (first..last).shuffled().first()
                secondNumber = (first..last).shuffled().first()
                result = firstNumber - secondNumber
            }
        }

        return ExpressionWithResult(firstNumber = firstNumber,
                                    secondNumber = secondNumber,
                                    result = result,
                                    expression = "")
    }
}