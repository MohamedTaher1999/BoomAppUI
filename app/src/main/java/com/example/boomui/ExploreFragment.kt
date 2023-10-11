package com.example.boomui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ExploreFragment : Fragment() {

    var grid=false;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_explore, container, false)



        var horizntalImage=view.findViewById<ImageView>(R.id.imageMenu)
        var gridImage=view.findViewById<ImageView>(R.id.imageGrid)
        var rec=view.findViewById<RecyclerView>(R.id.export_rec)
        val data = ArrayList<String>()
        data.add("red-fav")
        data.add("red-fawery")
        data.add("fav")
        data.add("nbe")
        data.add("red")
        data.add("Sell - Completed")
        data.add("fav")
        data.add("red-nbe")
        data.add("Sell - Completed")
        data.add("Buy - Open")
        data.add("red")

        horizntalImage.setOnClickListener(View.OnClickListener {
            if(grid){
                gridImage.setImageDrawable(requireContext().getResources().getDrawable(R.drawable.unselected_grid))
                horizntalImage.setImageDrawable(requireContext().getResources().getDrawable(R.drawable.selected_linear))
                rec.layoutManager = LinearLayoutManager(requireContext())
                val adapter = ExportHorizntalAdapter(data,requireContext())
                rec.adapter = adapter
            }
            grid=false
        })

        gridImage.setOnClickListener(View.OnClickListener {
            if(!grid){
                gridImage.setImageDrawable(requireContext().getResources().getDrawable(R.drawable.selected_grid))
                horizntalImage.setImageDrawable(requireContext().getResources().getDrawable(R.drawable.unselected_linear))
                rec.layoutManager=GridLayoutManager(requireContext(),2)
                val adapter = ExportVerticalAdapter(data,requireContext())
                rec.adapter = adapter
            }
            grid=true

        })


        rec.layoutManager = LinearLayoutManager(requireContext())

        val adapter = ExportHorizntalAdapter(data,requireContext())
        rec.adapter = adapter


        return view
    }
}