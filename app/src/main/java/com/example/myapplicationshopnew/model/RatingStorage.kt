package com.example.myapplicationshopnew.model

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.media.Rating

object RatingStorage {
    fun save(context: Context, productId: Int, rating: Float){
        val prefs = context.getSharedPreferences("rating_prefs", MODE_PRIVATE)
        prefs.edit().putFloat(productId.toString(), rating).apply()
    }

    fun get(context: Context, productId: Int): Float{
        val prefs = context.getSharedPreferences("rating_prefs", MODE_PRIVATE)
        return prefs.getFloat(productId.toString(), 0f)
    }

}