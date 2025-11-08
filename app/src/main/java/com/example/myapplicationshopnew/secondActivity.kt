package com.example.myapplicationshopnew

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import Product
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView


class SecondActivity : AppCompatActivity() {

    private val product = listOf(
            Product (id = 1, name = "ёлка зел", price = 4.0, description="описание 1", ImageRes = R.drawable.one),
            Product(id = 2, name = "ёлка зел2.0", price = 5.0, description="описание 1", ImageRes = R.drawable.two),
            Product(id = 3, name = "ёлка зел 3.0", price = 6.0, description="описание 1", ImageRes = R.drawable.three),
            Product(id = 4, name = "ёлка зел 4.0", price = 7.0, description="описание 1", ImageRes = R.drawable.four),
            Product(id = 5, name = "ёлка белая(с шишками)", price = 8.0, description="описание 1", ImageRes = R.drawable.five),
        )

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_second)

            val container = findViewById<LinearLayout>(R.id.shopWWW)

            product.forEach { product ->
                val view = layoutInflater.inflate(R.layout.item_product, container, false)
                view.findViewById<ImageView>(R.id.ivprodutctImge).setImageResource(product.ImageRes)
                view.findViewById<TextView>(R.id.tvproutctName).text = product.name
                view.findViewById<TextView>(R.id.tvproutctPrice).text = "$product.price $"

                container.addView(view)


        }
    }
}