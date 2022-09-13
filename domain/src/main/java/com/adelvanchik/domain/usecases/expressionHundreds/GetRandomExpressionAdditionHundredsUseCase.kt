package com.adelvanchik.domain.usecases.expressionHundreds

import com.adelvanchik.domain.models.ExpressionWithResult
import com.adelvanchik.domain.usecases.RandomExpression
import kotlin.math.exp

class GetRandomExpressionAdditionHundredsUseCase() {
    fun execute(): ExpressionWithResult {
        val expression: ExpressionWithResult = RandomExpression().execute(first = 1, last = 999, "+")
        return ExpressionWithResult(firstNumber = expression.firstNumber,
                                    secondNumber = expression.secondNumber,
                                    result = expression.firstNumber + expression.secondNumber,
                                    expression = "${expression.firstNumber} + ${expression.secondNumber}"
        )
    }
}