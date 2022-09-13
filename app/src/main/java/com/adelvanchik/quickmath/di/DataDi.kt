package com.adelvanchik.quickmath.di

import com.adelvanchik.dataapp.DataStorage
import com.adelvanchik.dataapp.repository.DataImpl
import com.adelvanchik.dataapp.sharedPreferences.SharedPrefData
import com.adelvanchik.domain.repository.Data
import org.koin.dsl.module

val dataModule = module {
    single<Data> {
        DataImpl(dataStorage = get())
    }
    single<DataStorage> {
        SharedPrefData(context = get())
    }
}