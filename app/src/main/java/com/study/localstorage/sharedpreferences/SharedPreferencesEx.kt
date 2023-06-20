package com.study.localstorage.sharedpreferences

import android.content.Context
import android.content.SharedPreferences

/**
 * XML 파일 위치
 * data > data > 패키지명 > shared_prefs > pref.xml
 */
class SharedPreferencesEx private constructor(context: Context) {
    companion object {
        private var instance: SharedPreferencesEx? = null

        fun getInstance(_context: Context): SharedPreferencesEx {
            return instance ?: synchronized(this) {
                instance ?: SharedPreferencesEx(_context).also {
                    instance = it
                }
            }
        }
    }

    private val prefFileName = "shared_pref"
    private val prefs: SharedPreferences
    private val prefsEditor: SharedPreferences.Editor

    init {
        prefs = context.getSharedPreferences(
            prefFileName,
            Context.MODE_PRIVATE
        )
        prefsEditor = prefs.edit()
    }

    fun getString(key: String?, defValue: String?): String {
        return prefs.getString(key, defValue)!!
    }

    fun putString(key: String?, value: String?) {
        prefsEditor.apply {
            putString(key, value)
            apply()
        }
    }

    fun getInt(key: String?, defValue: Int): Int {
        return prefs.getInt(key, defValue)
    }

    fun putInt(key: String?, value: Int?) {
        prefsEditor.apply {
            putInt(key, value!!)
            apply()
        }
    }

    fun getBoolean(key: String?, defValue: Boolean): Boolean {
        return prefs.getBoolean(key, defValue)
    }

    fun putBoolean(key: String?, value: Boolean) {
        prefsEditor.apply {
            putBoolean(key, value)
            apply()
        }
    }

    /**
     * pref 에 저장된 모든 key 를 리스트 형태로 가져온다.
     */
    fun getKeyList(): List<String> {
        val keys:Map<String, *> = prefs.all
        val keyList:MutableList<String> = mutableListOf()
        for ((key, /*value*/_) in keys.entries) {
            keyList.add(key)
        }
        return keyList
    }

    /**
     * pref 에 저장된 모든 key=value 를 가져온다.
     */
    fun getAllDataList(): HashMap<String, Any> {
        val keys: Map<String, *> = prefs.all
        val hashMap = HashMap<String, Any>()

        for ((key, value) in keys.entries) {
            hashMap[key] = value!!
        }

        return hashMap
    }

    fun remove(key: String) {
        prefsEditor.apply {
            remove(key)
            apply()
        }
    }

    fun removeAll() {
        prefsEditor.apply {
            clear()
            apply()
        }
    }
}