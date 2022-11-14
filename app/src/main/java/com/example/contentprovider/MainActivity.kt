package com.example.contentprovider

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    private lateinit var txtView: TextView
    private lateinit var btnDisplayAll: Button
    private lateinit var btnDisplayFirst: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

  fun  initViews(){
    txtView = findViewById(R.id.textviewId)
    btnDisplayAll = findViewById(R.id.button_display_all)
    btnDisplayFirst = findViewById(R.id.button_display_first)
    }

    fun onClickDisplayEntries(view: View?) {
        Log.d(TAG, "Yay, I was clicked!")
    }
}