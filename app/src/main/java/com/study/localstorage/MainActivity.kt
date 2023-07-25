package com.study.localstorage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.asLiveData
import com.study.localstorage.databinding.ActivityMainBinding
import com.study.localstorage.datastore.DatastoreEx
import com.study.localstorage.sharedpreferences.EncryptedSharedPreferencesEx
import com.study.localstorage.sharedpreferences.SharedPreferencesEx
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val sharedPreferencesEx by lazy {
        SharedPreferencesEx.getInstance(applicationContext)
    }
    private val encryptedSharedPreferencesEx by lazy {
        EncryptedSharedPreferencesEx.getInstance(applicationContext)
    }
    private lateinit var dataStoreEx: DatastoreEx

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivity = this@MainActivity

        val dataStore = this.settingDataStore
        dataStoreEx = DatastoreEx(dataStore)

        dataStoreEx.stringValue.asLiveData().observe(this) { it ->
            Timber.d("Observe LiveData : $it")
        }
    }

    //SharedPreference
    fun onTestButton1Clicked() {
        sharedPreferencesEx.putString("TEST_KEY", "SP_TEST_VALUE")
        val spValue = sharedPreferencesEx.getString("TEST_KEY", "EMPTY")
        Timber.d("sharedPreferencesEx Value : $spValue")

        encryptedSharedPreferencesEx.putString("TEST_KEY", "ESP_TEST_VALUE")
        val espValue = encryptedSharedPreferencesEx.getString("TEST_KEY", "EMPTY")
        Timber.d("encryptedSharedPreferencesEx Value : $espValue")
    }

    //DataStore
    fun onTestButton2Clicked() {
        CoroutineScope(Dispatchers.IO).launch {
            dataStoreEx.saveStringValue("${System.currentTimeMillis()}")
        }
    }

    //ROOM
    fun onTestButton3Clicked() {

    }
}