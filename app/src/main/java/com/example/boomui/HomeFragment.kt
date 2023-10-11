package com.example.boomui

import android.graphics.Color
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
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
        var marketContainer=view.findViewById<LinearLayoutCompat>(R.id.marketContainer)
        var txtProfit=view.findViewById<TextView>(R.id.txtProfit)
        var txtOneHundredTwentyFive=view.findViewById<TextView>(R.id.txtOneHundredTwentyFive)
        var imageArrowdown=view.findViewById<ImageView>(R.id.imageArrowdown)
        var marketText=view.findViewById<TextView>(R.id.marketText)

        loadFragment(MyOrdersFragment())
        myOrdersTextView.setOnClickListener(View.OnClickListener {
            if(!isMyOrdersSelected){
                loadFragment(MyOrdersFragment())
                myOrdersTextView.setBackgroundResource(R.drawable.rectangle_bg_white_a700_radius_15_5)
                myProtfolioTextView.setBackgroundResource(R.drawable.rectangle_bg_grey_a700_radius_15_5)
                marketContainer.setBackgroundDrawable(requireContext().getResources().getDrawable(R.drawable.rectangle_bg_green_a700_radius_8_5))
                txtProfit.setTextColor(Color.parseColor("#1ABB5B"))
                txtOneHundredTwentyFive.setTextColor(Color.parseColor("#1ABB5B"))
                imageArrowdown.setImageDrawable(requireContext().getResources().getDrawable(R.drawable.img_arrowdown))
                marketText.setText(resources.getString(R.string.lbl_market_is_open))

            }
            isMyOrdersSelected=true
        })
        myProtfolioTextView.setOnClickListener(View.OnClickListener {
            if(isMyOrdersSelected){
                loadFragment(MyProtfolioFragment())
                myProtfolioTextView.setBackgroundResource(R.drawable.rectangle_bg_white_a700_radius_15_5)
                myOrdersTextView.setBackgroundResource(R.drawable.rectangle_bg_grey_a700_radius_15_5)
                marketContainer.setBackgroundDrawable(requireContext().getResources().getDrawable(R.drawable.red_bg))
                txtProfit.setTextColor(Color.parseColor("#F01313"))
                txtOneHundredTwentyFive.setTextColor(Color.parseColor("#F01313"))
                imageArrowdown.setImageDrawable(requireContext().getResources().getDrawable(R.drawable.red_arr_e))
                marketText.setText(resources.getString(R.string.lbl_market_is_close))

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