package com.june.singleton_sharedpreference

import android.content.Context
import android.content.SharedPreferences

/**
 * XML 파일 위치
 * data > data > 패키지명 > shared_prefs > pref.xml
 *
 *
 * SharedPreferenceManager 인스턴스 초기화
 *  private lateinit var spm: SharedPreferencesManager
 *      ...
 *  override fun onCreate(savedInstanceState: Bundle?) {
 *      ...
 *      spm = SharedPreferencesManager.getInstance(this)!!
 *  }
 */

class SharedPreferenceManager {
    companion object {
        const val PREFERENCE_NAME = "pref"
        private var instance: SharedPreferenceManager? = null
        private lateinit var context: Context
        private lateinit var prefs: SharedPreferences
        private lateinit var prefsEditor: SharedPreferences.Editor

        fun getInstance(_context: Context): SharedPreferenceManager? {
            if (instance == null) {
                context = _context
                instance = SharedPreferenceManager()
            }
            return instance
        }
    }

    init {
        prefs = context.getSharedPreferences(
            PREFERENCE_NAME,
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

    fun getKeyList(): List<String>? {
        val keys:Map<String, *> = prefs.all
        val keyList:MutableList<String> = mutableListOf()
        for ((key, value) in keys.entries) {
            keyList.add(key)
        }
        return keyList
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