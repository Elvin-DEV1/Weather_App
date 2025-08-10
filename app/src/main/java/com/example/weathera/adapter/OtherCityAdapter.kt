package com.example.weathera.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weathera.databinding.ViewholderCityBinding
import com.example.weathera.model.CityModel

class OtherCityAdapter(private val items: ArrayList<CityModel>) :
    RecyclerView.Adapter<OtherCityAdapter.ViewHolder>() {

    private lateinit var context: Context

    class ViewHolder(val binding: ViewholderCityBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtherCityAdapter.ViewHolder {
        context = parent.context
        val binding = ViewholderCityBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OtherCityAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            cityTxt.text = item.cityName
            windTxt.text = "${item.wind} km/h"
            humidityTxt.text = "${item.humidity}%"
            tempTxt.text = "${item.temp}º"

            val drawableResourceId = holder.itemView.resources.getIdentifier(
                item.picPath,
                "drawable",
                context.packageName
            )

            Glide.with(context)
                .load(drawableResourceId)
                .into(pic)
        }
    }

    override fun getItemCount(): Int = items.size
}