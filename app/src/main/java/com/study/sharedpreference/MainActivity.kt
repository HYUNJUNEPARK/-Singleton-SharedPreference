package com.study.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.study.sharedpreference.repository.ESPManager
import com.study.sharedpreference.repository.SPManager

class MainActivity : AppCompatActivity() {
    lateinit var espManager: ESPManager
    lateinit var preferenceManager: SPManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        espManager = ESPManager.getInstance(this)
        preferenceManager = SPManager.getInstance(this)!!
    }

    fun testButton(v: View) {
        espManager.putInt("t1", 1)
        espManager.getInt("t1", 99).let {
            Log.d("testLog", "testButton: $it")
        }

        preferenceManager.putString("t1", "asdf")
        preferenceManager.getString("t1", "null").let {
            Log.d("testLog", "testButton: $it")
        }
    }
}