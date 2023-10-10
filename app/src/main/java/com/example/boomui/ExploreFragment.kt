package com.example.boomui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ExploreFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_explore, container, false)

        var rec=view.findViewById<RecyclerView>(R.id.export_rec)
        rec.layoutManager = LinearLayoutManager(requireContext())
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
        val adapter = ExportHorizntalAdapter(data,requireContext())
        rec.adapter = adapter


        return view
    }
}