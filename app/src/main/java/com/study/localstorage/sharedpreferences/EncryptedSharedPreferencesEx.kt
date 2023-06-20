package com.study.localstorage.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

/**
 * Android M (API 23) 이상 사용 가능
 *
 * 빌드 방법
 * implementation 'androidx.security:security-crypto-ktx:1.1.0-alpha03'
 * or
 * File > Project Structure > Dependencies > app > Declared Dependencies [+]
 * > Library Dependency> 'androidx.security' 검색 > security-crypto 최신 버전을 설치
 *
 * XML 파일 위치
 * data > data > 패키지명 > shared_prefs > encrypted_pref.xml
 *
 * MasterKey 정보
 * 키스토어 : AndroidKeyStore
 * keyAlias : "_androidx_security_master_key_"
 *
 * WARNING
 * keyset not found, will generate a new one
 * java.io.FileNotFoundException: can't read keyset;
 * the pref value __androidx_security_crypto_encrypted_prefs_key_keyset__ does not exist
 */

class EncryptedSharedPreferencesEx private constructor(context: Context) {
    companion object {
        private var instance: EncryptedSharedPreferencesEx? = null

        fun getInstance(_context: Context): EncryptedSharedPreferencesEx {
            return instance ?: synchronized(this) {
                instance ?: EncryptedSharedPreferencesEx(_context).also {
                    instance = it
                }
            }
        }
    }

    private val prefFileName = "encrypted_pref"
    private val prefs: SharedPreferences
    private val prefsEditor: SharedPreferences.Editor

    init {
        val masterKey = MasterKey
            .Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        prefs = EncryptedSharedPreferences.create(
            context,
            prefFileName,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, //to use for encrypting keys.
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM //to use for encrypting values.
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

    fun getKeyList(): List<String> {
        val keys:Map<String, *> = prefs.all
        val keyList:MutableList<String> = mutableListOf()
        for ((key, /*value*/_) in keys.entries) {
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