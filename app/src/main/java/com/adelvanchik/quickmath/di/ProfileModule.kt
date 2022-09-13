package com.adelvanchik.quickmath.di

import com.adelvanchik.quickmath.presentation.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val profileModule = module {
    viewModel<ProfileViewModel>()
}