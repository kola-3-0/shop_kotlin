package com.example.myapplicationshop.model

import Product
import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object CartStorage {
    // все элементы корзины (все что в нее добавлено)
    private val items = mutableListOf<Product>()

    private val gson = Gson()


    fun init(context: Context){
        val prefs = context.getSharedPreferences("settings", MODE_PRIVATE)
        val json = prefs.getString("cart_json", null)

        if (json != null){
            val type = object: TypeToken<List<Product>>() {}.type
            val restored: List<Product> = gson.fromJson(json, type)

            items.clear()
            items.addAll(restored)
        }
    }



    fun save(context: Context){
        val prefs = context.getSharedPreferences("settings", MODE_PRIVATE)
        val json = gson.toJson(items)
        prefs.edit().putString("cart_json" , json).apply()
    }

    // функция добавления элементов в корзину
    // new_item - товар, который мы добавляем
    fun add_item(context: Context, new_item: Product){
        items.add(new_item)
        save(context)
        }

    // удаление товара из корзины
    fun remove(context: Context, old_item: Product){
        items.removeAll {  it.id == old_item.id }
        save(context)
    }

    // получение списка всех товаров в корзине
    fun all() : List<Product> {
        return items.toList()
    }

    // удаление всего
    fun clear(context: Context){
        items.clear()
        save(context)
    }

}