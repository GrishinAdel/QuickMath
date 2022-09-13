package com.adelvanchik.dataapp.repository

import android.util.Log
import com.adelvanchik.dataapp.DataStorage
import com.adelvanchik.domain.repository.Data

class DataImpl(private val dataStorage: DataStorage): Data {
    override fun saveData(value: String, key: String): Boolean {
        return dataStorage.saveData(value, key)
    }

    override fun getData(key: String): String {
        Log.e("DataImpl","Запущен DataImpl")
        return dataStorage.getData(key)
    }

}