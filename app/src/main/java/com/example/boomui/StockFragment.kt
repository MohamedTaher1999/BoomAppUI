package com.example.boomui

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import java.util.Random


class StockFragment : Fragment() {

    private lateinit var lineChart: LineChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_stock, container, false)
        var back=view.findViewById<ImageView>(R.id.imageView3)
        back.setOnClickListener(View.OnClickListener {
            val transaction =requireActivity().supportFragmentManager.beginTransaction()
            transaction.add(R.id.container,ExploreFragment())
            transaction.commit()
            MainActivity.bottomNav.visibility=View.VISIBLE
        })
        var rec=view.findViewById<RecyclerView>(R.id.openOrdersRec)
        rec.layoutManager = LinearLayoutManager(requireContext())
        val data = ArrayList<String>()
        data.add("Buy - Open")
        data.add("Buy - Open")
        data.add("Buy - Open")
        data.add("Buy - Open")
        data.add("Buy - Open")
        data.add("Buy - Open")
        data.add("Buy - Open")
        data.add("Buy - Open")
        data.add("Buy - Open")
        data.add("Buy - Open")
        data.add("Buy - Open")
        val adapter = OrdersAdapter(data,requireContext())
        rec.adapter = adapter

        lineChart=view.findViewById(R.id.chart1)
        lineChart.setNoDataText("No data available") // Displayed when there is no data
        lineChart.setNoDataTextColor(Color.BLACK)
        lineChart.setDrawGridBackground(false)
        lineChart.description.isEnabled = false
        lineChart.animateX(2000)
        populateChartWithData()
        return view
    }
    private fun setData(dataPoints: List<Entry>) {

        val gradientDrawable = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(Color.parseColor("#ff810a"), Color.parseColor("#FFFFFF"))
        )
        gradientDrawable.setBounds(
            lineChart.left,
            lineChart.top,
            lineChart.right,
            lineChart.bottom
        )
        val dataSet = LineDataSet(dataPoints, "My Data")
        dataSet.color = Color.parseColor("#ff810a")
        dataSet.lineWidth = 2f
        dataSet.setCircleColor(Color.parseColor("#ff810a"))
        dataSet.setDrawCircles(false)
        dataSet.setDrawFilled(true)
        dataSet.fillDrawable = gradientDrawable
        dataSet.fillAlpha = 100
        dataSet.setDrawHighlightIndicators(false)

        val lineData = LineData(dataSet)
        lineChart.data = lineData

        // Hide Y axis
        val leftAxis = lineChart.axisLeft
        leftAxis.isEnabled = false

        // Hide right Y axis (if present)
        val rightAxis = lineChart.axisRight
        rightAxis.isEnabled = false

        // Hide X axis
        lineChart.xAxis.isEnabled = false

        lineChart.invalidate() // Refresh the chart
    }
    private fun populateChartWithData() {
        val random = Random()
        val dataPoints = mutableListOf<Entry>()

        for (i in 0 until 100) {
            val x = i.toFloat()
            val y = random.nextFloat() * 100  // Generate a random value between 0 and 100
            dataPoints.add(Entry(x, y))
        }

        setData(dataPoints)
    }
}