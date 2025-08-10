package com.example.weathera.activity

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weathera.R
import com.example.weathera.adapter.HourlyAdapter
import com.example.weathera.adapter.OtherCityAdapter
import com.example.weathera.databinding.ActivityMainBinding
import com.example.weathera.model.CityModel
import com.example.weathera.model.HourlyModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.chipNavigator.setItemSelected(R.id.home, true)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        initRecyclerviewHourly()
        initRecyclerviewOtherCity()
    }

    private fun initRecyclerviewOtherCity() {
        val items: ArrayList<CityModel> = ArrayList()

        items.add(CityModel("Hanoi", 25, "sunny", 12, 18, 22))
        items.add(CityModel("Paris", 28, "sunny", 5, 22, 12))
        items.add(CityModel("Berlin", 29, "sunny", 30, 25, 50))
        items.add(CityModel("Rome", 21, "sunny", 20, 20, 35))
        items.add(CityModel("London", 30, "sunny", 8, 5, 7))

        binding.view2.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false))
        binding.view2.adapter = OtherCityAdapter(items)
    }

    private fun initRecyclerviewHourly() {
        val items : ArrayList<HourlyModel> = ArrayList()

        items.add(HourlyModel("9 pm",28, "cloudy"))
        items.add(HourlyModel("10 pm",29, "sunny"))
        items.add(HourlyModel("11 pm",30, "windy"))
        items.add(HourlyModel("12 pm",31, "cloudy_2"))
        items.add(HourlyModel("1 am",10, "snowy"))

        binding.view1.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false))
        binding.view1.adapter = HourlyAdapter(items)
    }
}