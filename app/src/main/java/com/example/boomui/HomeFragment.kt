package com.example.boomui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeFragment : Fragment() {
    var isMyOrdersSelected=true


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_home, container, false)

        var myOrdersTextView=view.findViewById<TextView>(R.id.btnMyOrders)
        var myProtfolioTextView=view.findViewById<TextView>(R.id.btnMyProtfolio)

        loadFragment(MyOrdersFragment())
        myOrdersTextView.setOnClickListener(View.OnClickListener {
            if(!isMyOrdersSelected){
                loadFragment(MyOrdersFragment())
                myOrdersTextView.setBackgroundResource(R.drawable.rectangle_bg_white_a700_radius_15_5)
                myProtfolioTextView.setBackgroundResource(R.drawable.rectangle_bg_grey_a700_radius_15_5)

            }
            isMyOrdersSelected=true
        })
        myProtfolioTextView.setOnClickListener(View.OnClickListener {
            if(isMyOrdersSelected){
                loadFragment(MyProtfolioFragment())
                myProtfolioTextView.setBackgroundResource(R.drawable.rectangle_bg_white_a700_radius_15_5)
                myOrdersTextView.setBackgroundResource(R.drawable.rectangle_bg_grey_a700_radius_15_5)
            }
            isMyOrdersSelected=false
        })
        return view;
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.homeFragmentContainer,fragment)
        transaction.commit()
    }
}