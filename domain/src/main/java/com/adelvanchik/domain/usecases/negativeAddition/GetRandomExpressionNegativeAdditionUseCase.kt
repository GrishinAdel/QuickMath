package com.adelvanchik.domain.usecases.negativeAddition

import com.adelvanchik.domain.models.ExpressionWithResult
import com.adelvanchik.domain.usecases.RandomExpression

class GetRandomExpressionNegativeAdditionUseCase {
    fun execute(): ExpressionWithResult {
        val expression: ExpressionWithResult = RandomExpression().execute(first = -40, last = 40, "-+")
        return ExpressionWithResult(
            firstNumber = expression.firstNumber,
            secondNumber = expression.secondNumber,
            result = expression.firstNumber + expression.secondNumber,
            expression = "+"
        )
    }
}