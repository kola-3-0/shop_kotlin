package com.example.myapplicationshopnew.model
import Product
import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object HistoryStorage {

    private val items = mutableListOf< Oder>()
    private val gson = Gson()


    fun init(context: Context){
        val prefs = context.getSharedPreferences("settings", MODE_PRIVATE)
        val json = prefs.getString("history_json", null)

        if (json != null){
            val type = object: TypeToken<List<Oder>>() {}.type
            val restored: List<Oder> = gson.fromJson(json, type)

            items.clear()
            items.addAll(restored)
        }
    }



    fun save(context: Context){
        val prefs = context.getSharedPreferences("settings", MODE_PRIVATE)
        val json = gson.toJson(items)
        prefs.edit().putString("history_json" , json).apply()
    }

    // функция добавления элементов в корзину
    fun addAll(context: Context, new_list:List<Oder>){
        for (elem in new_list){
            items.add(elem)
        }
        save(context)
    }

    // получение списка всех товаров в корзине
    fun all() : List<Oder> {
        return items.toList()
    }

}