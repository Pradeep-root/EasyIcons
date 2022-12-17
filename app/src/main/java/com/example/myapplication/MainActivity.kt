package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.easyicons.EasyIcons

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val input = findViewById<EditText>(R.id.input)
        val button = findViewById<Button>(R.id.button)
        val easyIcons = findViewById<EasyIcons>(R.id.icon)

        button.setOnClickListener {
            easyIcons.setIconCode(input.text.toString())
        }
    }
}