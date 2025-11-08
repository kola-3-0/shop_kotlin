package com.example.myapplicationshopnew

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>( R.id.buttonStart)
        btnStart.setOnClickListener {
           // Toast.makeText(this, "кнопка нажата", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

//
//        btnStart.setOnLongClickListener {
//            Toast.makeText(this, "кнопка нажата", Toast.LENGTH_SHORT).show()
//            true
//        }

    }
}
