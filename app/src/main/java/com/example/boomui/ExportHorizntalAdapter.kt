package com.example.boomui

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExportHorizntalAdapter(private val mList: List<String>, val context: Context) : RecyclerView.Adapter<ExportHorizntalAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var currentItem=mList.get(position)
        if(currentItem.contains("red")){
            holder.text1.setTextColor(Color.parseColor("#DB334D"))
            holder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.red_arr_e))

        }
        if(currentItem.contains("fav")){
            holder.text2.setImageDrawable(context.getResources().getDrawable(R.drawable.fav_done))
        }

        if(currentItem.contains("fawery")){
            holder.mainImage.setImageDrawable(context.getResources().getDrawable(R.drawable.fawery_img))
            holder.title.text="Fawery"
            holder.des.text="Fawry Fintech Technologies"

        }
        if(currentItem.contains("nbe")){
            holder.mainImage.setImageDrawable(context.getResources().getDrawable(R.drawable.nbe_image))
            holder.title.text="NBE"
            holder.des.text="National Bank Of Egypt"

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.export_horizintal_card, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var text1=itemView.findViewById<TextView>(R.id.txtOneHundredTwentyFiveOne)
        var image=itemView.findViewById<ImageView>(R.id.imageVector)

        var text2=itemView.findViewById<ImageButton>(R.id.btnFavorite)

        var mainImage=itemView.findViewById<ImageView>(R.id.imageView2)

        var title=itemView.findViewById<TextView>(R.id.txtORSC)

        var des=itemView.findViewById<TextView>(R.id.txtOrascomConstru)

    }
}