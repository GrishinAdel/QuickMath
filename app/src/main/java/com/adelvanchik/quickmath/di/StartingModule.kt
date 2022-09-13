package com.adelvanchik.quickmath.di

import com.adelvanchik.quickmath.presentation.StartingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val startingModule = module {
    viewModel<StartingViewModel>()
}