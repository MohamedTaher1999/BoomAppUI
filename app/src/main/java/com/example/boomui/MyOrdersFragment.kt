package com.example.boomui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MyOrdersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_my_orders, container, false)

        var rec=view.findViewById<RecyclerView>(R.id.ordersRec)
        rec.layoutManager = LinearLayoutManager(requireContext())
        val data = ArrayList<String>()
        data.add("Buy - Open")
        data.add("Sell - Completed")
        data.add("Buy - Cancelled")
        data.add("Buy - Cancelled")
        data.add("Buy - Open")
        data.add("Sell - Completed")
        data.add("Buy - Open")
        data.add("Buy - Open")
        data.add("Sell - Completed")
        data.add("Buy - Open")
        data.add("Buy - Cancelled")
        val adapter = OrdersAdapter(data,requireContext())
        rec.adapter = adapter



        return view
    }

}