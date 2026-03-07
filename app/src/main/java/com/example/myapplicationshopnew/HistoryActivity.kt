package com.example.myapplicationshopnew
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationshop.model.CartStorage
import com.example.myapplicationshopnew.model.HistoryStorage

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_history)


    val rv = findViewById<RecyclerView>(R.id.rvHistory)


     val items = HistoryStorage.all()

     rv.layoutManager = LinearLayoutManager(this)
     rv.adapter = HistoryActivity(items)
}
}