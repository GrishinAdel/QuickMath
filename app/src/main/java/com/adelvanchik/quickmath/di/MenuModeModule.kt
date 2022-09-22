package com.adelvanchik.quickmath.di

import com.adelvanchik.quickmath.presentation.MenuModeModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val menuModeModel = module {
    viewModel<MenuModeModel>()
}