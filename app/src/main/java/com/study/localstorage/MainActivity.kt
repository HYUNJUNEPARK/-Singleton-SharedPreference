package com.study.localstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.study.localstorage.databinding.ActivityMainBinding
import com.study.localstorage.sharedpreferences.EncryptedSharedPreferencesEx
import com.study.localstorage.sharedpreferences.SharedPreferencesEx
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val sharedPreferencesEx by lazy {
        SharedPreferencesEx.getInstance(applicationContext)
    }
    private val encryptedSharedPreferencesEx by lazy {
        EncryptedSharedPreferencesEx.getInstance(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivity = this@MainActivity
    }

    fun onTestButton1Clicked() {
        sharedPreferencesEx.putString("TEST_KEY", "SP_TEST_VALUE")
        val spValue = sharedPreferencesEx.getString("TEST_KEY", "EMPTY")
        Timber.d("sharedPreferencesEx Value : $spValue")

        encryptedSharedPreferencesEx.putString("TEST_KEY", "ESP_TEST_VALUE")
        val espValue = encryptedSharedPreferencesEx.getString("TEST_KEY", "EMPTY")
        Timber.d("encryptedSharedPreferencesEx Value : $espValue")
    }

    fun onTestButton2Clicked() {

    }

    fun onTestButton3Clicked() {

    }
}