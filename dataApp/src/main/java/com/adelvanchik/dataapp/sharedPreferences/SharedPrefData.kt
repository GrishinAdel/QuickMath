package com.adelvanchik.dataapp.sharedPreferences

import android.content.Context
import android.util.Log
import com.adelvanchik.dataapp.DataStorage

private const val Shared_Prefs_Name = "DataStorage"


class SharedPrefData(private val context: Context): DataStorage {

    private val sharedPreferences = context.getSharedPreferences(Shared_Prefs_Name, Context.MODE_PRIVATE)

    override fun saveData(value: String, key: String): Boolean{
        sharedPreferences.edit().putString(key, value).apply()
        return true
    }

    override fun getData(key: String): String {
        Log.e("SharePref","Запущен SharedPreferences")
        return sharedPreferences.getString(key, "0")?:"0"
     }

}