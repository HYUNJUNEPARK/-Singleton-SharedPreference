package com.study.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.module.sharedpreferencemanager.SharedPreferencesManager
import com.study.sharedpreference.repository.ESPManager

class MainActivity : AppCompatActivity() {
    private lateinit var espManager: ESPManager
    private lateinit var sharedPreferencesManager: SharedPreferencesManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        espManager = ESPManager.getInstance(applicationContext)
        sharedPreferencesManager = SharedPreferencesManager.getInstance(applicationContext)
    }

    fun testButton(v: View) {
        sharedPreferencesManager.putString("t1", "asdf")
        sharedPreferencesManager.getString("t1", "null").let {
            Log.d("testLog", "testButton: $it")
        }
    }
}