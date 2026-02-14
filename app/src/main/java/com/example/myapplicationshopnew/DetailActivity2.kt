package com.example.myapplicationshopnew

import Product
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationshop.model.CartStorage

class DetailActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail2)

//      Получение данных из intent
        val productName = intent.getStringExtra("name") ?: "Товар"
        val productPrice = intent.getDoubleExtra("peice", 0.0)
        val productImageRes = intent.getIntExtra("ImageRes", 0)
        val productDescription = intent.getStringExtra("description") ?: "Описание отсутствует"
        val productId = intent.getIntExtra("id", -1)

//      Находим view на экране
        val detailImage = findViewById<ImageView>(R.id.detailImage)
        val detailName = findViewById<TextView>(R.id.detailName)
        val detailPrice = findViewById<TextView>(R.id.detailPrice)
        val detailDescription = findViewById<TextView>(R.id.detailDescription)
        val buyButton = findViewById<Button>(R.id.buyButton)
        val backButton = findViewById<Button>(R.id.backButton)

        detailImage.setImageResource(productImageRes)
        detailName.text = productName
        detailPrice.text = "$productPrice $"
        detailDescription.text = productDescription

        buyButton.setOnClickListener {
            val one_new_prodect = Product(id = productId,
                                          name = productName,
                                          price = productPrice,
                                          description = productDescription,
                                          ImageRes = productImageRes  )
            CartStorage.add_item(new_item = one_new_prodect)
            Toast.makeText(this, "товар $productName добавлен в корзину!", Toast.LENGTH_SHORT)
                .show()
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}