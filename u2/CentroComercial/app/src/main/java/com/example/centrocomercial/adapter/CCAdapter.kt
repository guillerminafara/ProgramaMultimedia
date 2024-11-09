package com.example.centrocomercial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.centrocomercial.Clases.centrosComerciales
import com.example.centrocomercial.R


class CCAdapter(private val centrosList: List<centrosComerciales>) : RecyclerView.Adapter<CCViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CCViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return CCViewHolder(layoutInflater.inflate(R.layout.activity_main, parent, false))
    }

    override fun getItemCount(): Int {
        return centrosList.size
    }

    override fun onBindViewHolder(holder: CCViewHolder, position: Int) {
        val item= centrosList[position]
        holder.render(item)
    }

}