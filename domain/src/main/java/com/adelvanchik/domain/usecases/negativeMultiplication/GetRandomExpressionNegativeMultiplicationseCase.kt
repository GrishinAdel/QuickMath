package com.adelvanchik.domain.usecases.negativeMultiplication

import com.adelvanchik.domain.models.ExpressionWithResult
import com.adelvanchik.domain.usecases.RandomExpression

class GetRandomExpressionNegativeMultiplicationseCase {
    fun execute(): ExpressionWithResult {
        val expression: ExpressionWithResult = RandomExpression().execute(first = 2, last = 9, "-*")
        return ExpressionWithResult(firstNumber = expression.firstNumber,
            secondNumber = expression.secondNumber,
            result = expression.firstNumber * expression.secondNumber,
            expression = "*")
    }
}