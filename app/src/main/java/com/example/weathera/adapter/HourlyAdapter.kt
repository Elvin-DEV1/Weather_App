package com.example.weathera.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weathera.databinding.ViewholderHourlyBinding
import com.example.weathera.model.HourlyModel

class HourlyAdapter(private val items: ArrayList<HourlyModel>) :
    RecyclerView.Adapter<HourlyAdapter.ViewHolder>() {
    private lateinit var context: Context

    class ViewHolder(val binding: ViewholderHourlyBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = ViewholderHourlyBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.apply {
            hourTxt.text = item.hour
            tempTxt.text = item.temp.toString()

            val drawableSourceId = holder.itemView.resources.getIdentifier(
                item.picPath,
                "drawable",
                context.packageName
            )
            Glide.with(context)
                .load(drawableSourceId)
                .into(pic)
        }
    }
}