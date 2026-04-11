package com.example.myapplicationshopnew

import Product
import android.os.Bundle
import android.view.MotionEvent
import android.view.animation.AnimationUtils
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
        val favorButton = findViewById<Button>(R.id.favorButton)

        detailImage.setImageResource(productImageRes)
        detailName.text = productName
        detailPrice.text = "$productPrice $"
        detailDescription.text = productDescription

        detailImage.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade))
        detailName.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade))
        detailPrice.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade))
        detailDescription.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade))

        buyButton.setOnClickListener {
            val one_new_prodect = Product(
                id = productId,
                name = productName,
                price = productPrice,
                description = productDescription,
                ImageRes = productImageRes
            )
            CartStorage.add_item(this, new_item = one_new_prodect)
            Toast.makeText(this, "товар $productName добавлен в корзину!", Toast.LENGTH_SHORT)
                .show()
        }
        buyButton.setOnTouchListener { v, event ->
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

        backButton.setOnClickListener {
            finish()
        }
        backButton.setOnTouchListener { v, event ->
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
        favorButton.setOnClickListener {
            val one_new_prodect = Product(
                id = productId,
                name = productName,
                price = productPrice,
                description = productDescription,
                ImageRes = productImageRes
            )
            val addet = FavoriteStorage.add_item(this, new_item = one_new_prodect)
            if (addet == true) {
                Toast.makeText(this, "товар $productName добавлен в избранные!", Toast.LENGTH_SHORT)
                    .show()

                if (addet == false) {
                    Toast.makeText(this, "товар $productName добавлен ранее", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        favorButton.setOnTouchListener { v, event ->
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
