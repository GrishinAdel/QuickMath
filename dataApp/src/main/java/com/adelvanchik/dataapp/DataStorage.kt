package com.adelvanchik.dataapp

interface DataStorage {
    fun saveData(value: String, key: String): Boolean

    fun getData(key: String): String
}