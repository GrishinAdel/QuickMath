package com.adelvanchik.quickmath.di

import com.adelvanchik.quickmath.presentation.ProfileViewModel
import com.adelvanchik.quickmath.presentation.SettingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val settingModule = module {
    viewModel<SettingViewModel>()
}