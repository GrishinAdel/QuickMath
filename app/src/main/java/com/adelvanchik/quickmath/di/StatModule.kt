package com.adelvanchik.quickmath.di

import com.adelvanchik.quickmath.presentation.StatViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val statModule = module {
    viewModel<StatViewModel>()
}