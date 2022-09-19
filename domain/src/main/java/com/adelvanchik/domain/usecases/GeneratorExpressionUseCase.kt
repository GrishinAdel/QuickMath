package com.adelvanchik.domain.usecases

import com.adelvanchik.domain.models.ExpressionWithResult
import com.adelvanchik.domain.usecases.expressionHundreds.GetRandomExpressionAdditionHundredsUseCase
import com.adelvanchik.domain.usecases.expressionHundreds.GetRandomExpressionSubtractionHundredsUseCase
import com.adelvanchik.domain.usecases.expressionSimple.GetRandomExpressionAdditionSimpleUseCase
import com.adelvanchik.domain.usecases.expressionSimple.GetRandomExpressionSubtractionSimpleUseCase
import com.adelvanchik.domain.usecases.multiplicationTable.GetRandomExpressionMultiplicationTableDivisionUseCase
import com.adelvanchik.domain.usecases.multiplicationTable.GetRandomExpressionMultiplicationTableUseCase
import com.adelvanchik.domain.usecases.negativeAddition.GetRandomExpressionNegativeAdditionUseCase
import com.adelvanchik.domain.usecases.negativeAddition.GetRandomExpressionNegativeSubtractionseCase
import com.adelvanchik.domain.usecases.negativeMultiplication.GetRandomExpressionNegativeDivisionseCase
import com.adelvanchik.domain.usecases.negativeMultiplication.GetRandomExpressionNegativeMultiplicationseCase

class GeneratorExpressionUseCase() {

    fun execute(mode: String): ExpressionWithResult {
        val choice = (1..2).shuffled().first()
        var expression: ExpressionWithResult
        when (mode) {
            "HundredsAdditionSubtraction" -> {
                if (choice == 1) expression =
                    GetRandomExpressionSubtractionHundredsUseCase().execute()
                else expression = GetRandomExpressionAdditionHundredsUseCase().execute()
            }
            "SimpleAdditionSubtraction" -> {
                if (choice == 1) expression =
                    GetRandomExpressionSubtractionSimpleUseCase().execute()
                else expression = GetRandomExpressionAdditionSimpleUseCase().execute()
            }
            "MultiplicationTable" -> {
                expression = GetRandomExpressionMultiplicationTableUseCase().execute()
            }
            "MultiplicationDivision" -> {
                if (choice == 1) expression =
                    GetRandomExpressionMultiplicationTableUseCase().execute()
                else expression =
                    GetRandomExpressionMultiplicationTableDivisionUseCase().execute()
            } "NegativeAdditionSubtraction" -> {
                if (choice == 1) expression =
                    GetRandomExpressionNegativeSubtractionseCase().execute()
                else expression = GetRandomExpressionNegativeAdditionUseCase().execute()
            } "NegativeMultiplicationDivision" -> {
                if (choice == 1) expression =
                    GetRandomExpressionNegativeMultiplicationseCase().execute()
                else expression = GetRandomExpressionNegativeDivisionseCase().execute()
            } "NegativeMixed" -> {
                val mixed = (1..2).shuffled().first()
                if (mixed == 1) {
                    if (choice == 1) expression =
                        GetRandomExpressionNegativeSubtractionseCase().execute()
                    else expression = GetRandomExpressionNegativeAdditionUseCase().execute()
                } else  {
                    if (choice == 1) expression =
                        GetRandomExpressionNegativeMultiplicationseCase().execute()
                    else expression = GetRandomExpressionNegativeDivisionseCase().execute()
                }
            } "mixed" -> {
                val mixed = (1..3).shuffled().first()
                if (mixed == 1) {
                    if (choice == 1) expression =
                        GetRandomExpressionSubtractionHundredsUseCase().execute()
                    else expression = GetRandomExpressionAdditionHundredsUseCase().execute()
                } else if (mixed == 2) {
                    if (choice == 1) expression =
                        GetRandomExpressionSubtractionSimpleUseCase().execute()
                    else expression = GetRandomExpressionAdditionSimpleUseCase().execute()
                } else {
                    if (choice == 1) expression =
                        GetRandomExpressionMultiplicationTableUseCase().execute()
                    else expression =
                        GetRandomExpressionMultiplicationTableDivisionUseCase().execute()
                }
            } else -> expression = ExpressionWithResult(1,1,1, "nullMode")
        }
        return expression
    }
}
