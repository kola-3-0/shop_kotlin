package com.example.myapplicationshopnew

import android.content.Intent
import android.os.Bundle
import android.os.RecoverySystem
import android.view.MotionEvent
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationshop.model.CartStorage
import com.example.myapplicationshopnew.model.HistoryStorage
import com.example.myapplicationshopnew.model.Oder
import java.util.Date
import java.util.Locale.getDefault

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)
        //1
        val rv = findViewById<RecyclerView>(R.id.tvCartList)
        val tvTotal = findViewById<TextView>(R.id.tvCartTitleSum)
        val btnClear = findViewById<Button>(R.id.btnClearCart)
        val btrMakeOrder = findViewById<Button>(R.id.btnMakeOrder)
        val btnOpenHistory = findViewById<Button>(R.id.btnOoenHistory)
        //2
        val items = CartStorage.all()
        //3
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = CartAdapter(items)
        //4
        var total = 0.0

        for (elem in items) {
            total += elem.price
        }
        tvTotal.text = "ИТОГО: ${total}"

        //5
        btnClear.setOnClickListener {
            CartStorage.clear(this)
            rv.adapter = CartAdapter(emptyList())
            tvTotal.text = "ИТОГО: 0"
        }
        btnClear.setOnTouchListener { v, event ->
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
        //6
        btnOpenHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }
        btnOpenHistory.setOnTouchListener { v, event ->
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
        //7
        btrMakeOrder.setOnClickListener {
            val cartItems = CartStorage.all()
            if (cartItems.isEmpty()) {
                return@setOnClickListener
            }
            val formatter = java.text.SimpleDateFormat("dd.MM.yyyy HH.mm", getDefault())
            val dateTime = formatter.format(Date())

            val purchases = mutableListOf<Oder>()

            for (elem in cartItems) {

                var found = false //следит за тем нашелся ли товар или нет
                //проверка всех товаров в истории
                 for (i in purchases.indices){
                     if (elem.id == purchases[i].product.id){
                         //увеличивем количество
                         var old = purchases[i]
                         purchases[i] = Oder(old.product,
                                            old.dateTime,
                                            old.quantity +1,
                                            old.product.price * (old.quantity +1))
                         found = true
                         break
                     }
                 }
                //если товара нет
                if(found == false){
                    purchases.add(Oder(elem, dateTime, 1, elem.price*1))
                }
            }


            HistoryStorage.addAll(this, purchases)

            CartStorage.clear(this)

            rv.adapter = CartAdapter(emptyList())
            tvTotal.text = "ИТОГО: 0"



        }
        btrMakeOrder.setOnTouchListener { v, event ->
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


    }
}
