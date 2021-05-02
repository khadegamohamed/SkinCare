package com.example.skincare.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.skincare.R

class RecyclerAdapter :RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var titels = arrayOf("")
    private var details = arrayOf("")
    private var  images = intArrayOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
      val v= LayoutInflater.from(parent.context).inflate(R.layout.temp,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return titels.size
        return details.size
        return images.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
         holder.IMGrec.setImageResource(images[position])
        holder.TEXrec2 .text = details[position]
        holder.TEXrec1.text = titels[position]

    }
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var IMGrec:ImageView
        var TEXrec1 :TextView
        var TEXrec2 :TextView
        init {
            IMGrec =itemView.findViewById(R.id.IMGrec)
            TEXrec1 = itemView.findViewById(R.id.TEXrec1)
            TEXrec2 = itemView.findViewById(R.id.TEXrec2)
        }
    }

}