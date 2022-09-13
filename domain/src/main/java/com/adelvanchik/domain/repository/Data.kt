package com.adelvanchik.domain.repository

interface Data {
    fun saveData(value: String,key: String): Boolean

    fun getData(key: String): String
}