package com.study.localstorage.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import timber.log.Timber
import java.io.IOException

//PreferenceDataStoreEx
class DatastoreEx(
    private val dataStore: DataStore<Preferences>
) {
    private val stringKey = stringPreferencesKey("key_string")
    private val booleanKey = booleanPreferencesKey("key_boolean")
    private val intKey = intPreferencesKey("key_int")

    // stringKey 키 값과 대응되는 값 반환
    val stringValue : Flow<String> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                Timber.e("BooleanValue exception : $exception")
                throw exception
            }
        }
        .map { preferences ->
            preferences[stringKey] ?: ""
        }

    val booleanValue : Flow<Boolean> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                Timber.e("BooleanValue exception : $exception")
                throw exception
            }
        }
        .map { preferences ->
            preferences[booleanKey] ?: true
        }

    val intValue : Flow<Int> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                Timber.e("BooleanValue exception : $exception")
                throw exception
            }
        }
        .map { preferences ->
            preferences[intKey] ?: 0
        }

    suspend fun saveStringValue(stringValue : String){
        dataStore.edit { preferences ->
            preferences[stringKey] = stringValue
        }
    }

    suspend fun saveIntValue(intValue: Int) {
        dataStore.edit { preferences ->
            preferences[intKey] = intValue
        }
    }

    suspend fun saveBooleanValue(booleanValue: Boolean) {
        dataStore.edit { preferences ->
            preferences[booleanKey] = booleanValue
        }
    }
}