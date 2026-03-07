package com.example.myapplicationshopnew.model

import Product

data class Oder(
    val product: Product,
    val dateTime: String,
    val quantity: Int,
    val totalPrice: Double
)
