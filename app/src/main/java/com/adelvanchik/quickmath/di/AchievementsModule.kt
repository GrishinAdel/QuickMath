package com.adelvanchik.quickmath.di

import com.adelvanchik.quickmath.presentation.AchievementsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val achievementsModule = module {
    viewModel<AchievementsViewModel>()
}