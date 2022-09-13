package com.adelvanchik.quickmath.di

import com.adelvanchik.domain.usecases.GeneratorExpressionUseCase
import com.adelvanchik.domain.usecases.RandomExpression
import com.adelvanchik.domain.usecases.betterResult.GetDataUseCase
import com.adelvanchik.domain.usecases.betterResult.SaveDataUseCase
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
import org.koin.dsl.module

val domainModule = module {

    factory<GetRandomExpressionAdditionHundredsUseCase> {
        GetRandomExpressionAdditionHundredsUseCase()
    }

    factory<GetRandomExpressionSubtractionHundredsUseCase> {
        GetRandomExpressionSubtractionHundredsUseCase()
    }

    factory<GetRandomExpressionAdditionSimpleUseCase>{
        GetRandomExpressionAdditionSimpleUseCase()
    }

    factory<GetRandomExpressionSubtractionSimpleUseCase> {
        GetRandomExpressionSubtractionSimpleUseCase()
    }

    factory<GetRandomExpressionMultiplicationTableDivisionUseCase> {
        GetRandomExpressionMultiplicationTableDivisionUseCase()
    }

    factory<GetRandomExpressionMultiplicationTableUseCase> {
        GetRandomExpressionMultiplicationTableUseCase()
    }

    factory<GetRandomExpressionNegativeAdditionUseCase> {
        GetRandomExpressionNegativeAdditionUseCase()
    }

    factory<GetRandomExpressionNegativeSubtractionseCase> {
        GetRandomExpressionNegativeSubtractionseCase()
    }

    factory<GetRandomExpressionNegativeMultiplicationseCase> {
        GetRandomExpressionNegativeMultiplicationseCase()
    }

    factory<GetRandomExpressionNegativeDivisionseCase> {
        GetRandomExpressionNegativeDivisionseCase()
    }

    factory <RandomExpression>{
        RandomExpression()
    }

    factory <GeneratorExpressionUseCase> {
        GeneratorExpressionUseCase()
    }

    factory<GetDataUseCase> {
        GetDataUseCase(data = get())
    }

    factory<SaveDataUseCase> {
        SaveDataUseCase(data = get())
    }
}