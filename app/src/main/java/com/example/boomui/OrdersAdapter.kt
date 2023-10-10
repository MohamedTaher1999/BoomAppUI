package com.example.boomui

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrdersAdapter(private val mList: List<String>,val context: Context) : RecyclerView.Adapter<OrdersAdapter.ViewHolder>() {

    // create new views


    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var currentItem=mList.get(position)

        if(!currentItem.contains("Open")){
            holder.linear.visibility=View.GONE
        }
        if(currentItem.contains("Cancelled")){
            holder.textView.setTextColor(Color.parseColor("#F01313"))
            holder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.error_info))
        }

        holder.textView.text=currentItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.orders_card, parent, false)

        return ViewHolder(view)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var textView=itemView.findViewById<TextView>(R.id.txtBuyOpen)
        var image=itemView.findViewById<ImageView>(R.id.imageLock)

        var linear =itemView.findViewById<LinearLayout>(R.id.linearRowedit)

    }
}