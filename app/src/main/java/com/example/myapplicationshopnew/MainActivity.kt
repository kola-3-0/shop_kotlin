package com.example.myapplicationshopnew

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.MotionEvent
import android.view.animation.AnimationUtils
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationshop.model.CartStorage
import com.example.myapplicationshopnew.model.HistoryStorage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        HistoryStorage.init(this)
        FavoriteStorage.init(this)

        CartStorage.init(this)
        val btnStart = findViewById<Button>( R.id.buttonStart)
        btnStart.setOnClickListener {
           // Toast.makeText(this, "кнопка нажата", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        btnStart.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN){
                v.startAnimation(AnimationUtils.loadAnimation(v.context, R.anim.scale_down))
            }

            if (event.action == MotionEvent.ACTION_UP){
                v.startAnimation(AnimationUtils.loadAnimation(v.context, R.anim.scale_up))
            }

            if (event.action == MotionEvent.ACTION_CANCEL){
                v.startAnimation(AnimationUtils.loadAnimation(v.context, R.anim.scale_up))
            }

            false
        }

//
//        btnStart.setOnLongClickListener {
//            Toast.makeText(this, "кнопка нажата", Toast.LENGTH_SHORT).show()
//            true
//        }

    }
}
