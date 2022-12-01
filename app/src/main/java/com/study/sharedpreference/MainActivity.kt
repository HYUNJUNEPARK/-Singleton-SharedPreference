package com.study.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.study.sharedpreference.repository.ESPManager
import com.study.sharedpreference.repository.SharedPreferenceManager

class MainActivity : AppCompatActivity() {
    lateinit var espManager: ESPManager
    lateinit var preferenceManager: SharedPreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        espManager = ESPManager.getInstance(this)
        preferenceManager = SharedPreferenceManager.getInstance(this)!!
    }
}