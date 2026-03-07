package com.example.myapplicationshopnew

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationshopnew.CartAdapter.VH
import com.example.myapplicationshopnew.model.Oder

class HistoryAdapter (
    private val items: List<Oder>): RecyclerView.Adapter<HistoryAdapter.VH>(){
        class VH(view: View) : RecyclerView.ViewHolder(view){
            val image: ImageView = view.findViewById<ImageView>(R.id.tvHistoryImge)
            val name : TextView = view.findViewById<TextView>(R.id.tvHistoryName)
            val price : TextView = view.findViewById<TextView>(R.id.tvproutctPrice)
            val date: TextView = view.findViewById<TextView>(R.id.tvproutctDate)

        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryAdapter.VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)
        return VH(view)
    }
    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: HistoryAdapter.VH, position: Int) {
        val oder = items[position]

        holder.image.setImageResource(oder.product.ImageRes)
        holder.name.text = oder.product.name
        holder.price.text = "${oder.product.price} x ${oder.product.price} $ = ${oder.totalPrice}"
        holder.date.text = oder.dateTime
    }





    }
