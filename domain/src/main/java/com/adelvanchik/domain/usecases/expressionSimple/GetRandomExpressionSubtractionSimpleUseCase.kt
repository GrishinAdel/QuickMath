package com.adelvanchik.domain.usecases.expressionSimple

import com.adelvanchik.domain.models.ExpressionWithResult
import com.adelvanchik.domain.usecases.RandomExpression

class GetRandomExpressionSubtractionSimpleUseCase() {
    fun execute(): ExpressionWithResult {
        val expression: ExpressionWithResult = RandomExpression().execute(first = 1, last = 99, "-")
        return ExpressionWithResult(firstNumber = expression.firstNumber,
                                    secondNumber = expression.secondNumber,
                                    result = expression.firstNumber - expression.secondNumber,
                                    expression = "${expression.firstNumber} - ${expression.secondNumber}")
    }
}