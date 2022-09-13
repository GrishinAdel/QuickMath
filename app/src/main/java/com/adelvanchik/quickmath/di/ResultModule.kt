package com.adelvanchik.quickmath.di

import com.adelvanchik.quickmath.presentation.ResultViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val resultModule = module {
    viewModel<ResultViewModel>()
}