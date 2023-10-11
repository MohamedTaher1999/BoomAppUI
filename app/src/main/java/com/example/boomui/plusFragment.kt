package com.example.boomui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton


class plusFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_plus, container, false)

        var close=view.findViewById<ImageButton>(R.id.btnClose)
        close.setOnClickListener(View.OnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
            MainActivity.bottomNav.visibility=View.VISIBLE

        })
        return view
    }

}