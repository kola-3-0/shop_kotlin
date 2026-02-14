package com.example.myapplicationshopnew

import android.os.Bundle
import android.os.RecoverySystem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationshop.model.CartStorage

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)
    //1
    val rv = findViewById<RecyclerView>(R.id.tvCartList)
    val tvTotal = findViewById<TextView>(R.id.tvCartTitleSum)
    val btnClear = findViewById<Button>(R.id.btnClearCart)
    //2
    val items = CartStorage.all()
    //3
    rv.layoutManager  = LinearLayoutManager(this)
    rv.adapter = CartAdapter(items)
    //4
    var total = 0.0

    for (elem in items){
        total += elem.price
    }
    tvTotal.text = "ИТОГО: ${total}"

    //5
    btnClear.setOnClickListener {
        CartStorage.clear()
        rv.adapter = CartAdapter(emptyList())
    }
        tvTotal.text = "ИТОГО: 0"



    }
}
