package com.example.myapplicationshopnew

import Product
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductGridAdapter(
    private val context: android.content.Context,
    private  val products: List<Product>
) : RecyclerView.Adapter<ProductGridAdapter.VH>(){

    class VH(view: View) : RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById<ImageView>(R.id.ivprodutctImge)
        val name : TextView = view.findViewById<TextView>(R.id.tvproutctName)
        val price : TextView = view.findViewById<TextView>(R.id.tvproutctPrice)
        val button : Button = view.findViewById<Button>(R.id.btnDetails)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_grid, parent, false)
        return VH(view)
    }

    override fun getItemCount() = products.size
    override fun onBindViewHolder(holder: VH, position: Int) {
        val product = products[position]

        holder.image.setImageResource(product.ImageRes)
        holder.name.text = product.name
        holder.price.text = "${product.price} $"

        holder.button.setOnClickListener {
            val intent = Intent(context, DetailActivity2::class.java).apply {
                putExtra("name", product.name)
                putExtra("peice", product.price)
                putExtra("ImageRes", product.ImageRes)
                putExtra("description", product.description)

            }
            context.startActivity(intent)
        }

    }



}
