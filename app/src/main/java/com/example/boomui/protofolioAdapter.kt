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

class protofolioAdapter(private val mList: List<String>, val context: Context) : RecyclerView.Adapter<protofolioAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var currentItem=mList.get(position)
        if(currentItem=="red"){
            holder.text1.setTextColor(Color.parseColor("#DB334D"))
            holder.text2.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.rectangle_bg_red))

            holder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.red_arrow))
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.protfolio_card, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var text1=itemView.findViewById<TextView>(R.id.txtOneHundredTwentyFiveOne)
        var text2=itemView.findViewById<TextView>(R.id.txtPriceOne)
        var image=itemView.findViewById<ImageView>(R.id.imageVector)
    }
}