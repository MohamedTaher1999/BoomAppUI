package com.example.boomui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ExploreFragment : Fragment(),RecyclerViewClickListener  {

    var grid=false;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.white)

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
                val adapter = ExportHorizntalAdapter(data,requireContext(),this)
                rec.adapter = adapter
            }
            grid=false
        })

        gridImage.setOnClickListener(View.OnClickListener {
            if(!grid){
                gridImage.setImageDrawable(requireContext().getResources().getDrawable(R.drawable.selected_grid))
                horizntalImage.setImageDrawable(requireContext().getResources().getDrawable(R.drawable.unselected_linear))
                rec.layoutManager=GridLayoutManager(requireContext(),2)
                val adapter = ExportVerticalAdapter(data,requireContext(),this)
                rec.adapter = adapter
            }
            grid=true

        })


        rec.layoutManager = LinearLayoutManager(requireContext())

        val adapter = ExportHorizntalAdapter(data,requireContext(),this)
        rec.adapter = adapter


        return view
    }

    override fun onResume() {
        super.onResume()
        MainActivity.bottomNav.visibility=View.VISIBLE
    }

    override fun onItemClick() {
        val transaction =requireActivity().supportFragmentManager.beginTransaction()
        transaction.add(R.id.container,StockFragment())
        transaction.commit()
        MainActivity.bottomNav.visibility=View.GONE

    }
}