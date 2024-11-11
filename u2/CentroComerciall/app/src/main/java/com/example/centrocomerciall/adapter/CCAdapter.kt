package com.example.centrocomerciall.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.centrocomerciall.R
import com.example.centrocomerciall.clases.CCProvider
import com.example.centrocomerciall.clases.CentrosComerciales

class CCAdapter ( private val centrosList: List<CentrosComerciales>,
                  private val onClick: (CentrosComerciales) -> Unit) :
    RecyclerView.Adapter<CCAdapter.CCViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CCViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CCViewHolder(layoutInflater.inflate(R.layout.activity_main2, parent, false))
    }

    override fun getItemCount(): Int {
      return centrosList.size
    }

    override fun onBindViewHolder(holder: CCViewHolder, position: Int) {
       val item = centrosList[position]
        return holder.bind(item)
    }
    inner class CCViewHolder(view: View):RecyclerView.ViewHolder(view){
        val ccCard=view.findViewById<CardView>(R.id.card1)
        val ccNombre=view.findViewById<TextView>(R.id.nombree)
        val ccDireccion=view.findViewById<TextView>(R.id.direccion)
        val ccTiendas=view.findViewById<TextView>(R.id.tiendas)
        val ccImage=view.findViewById<ImageView>(R.id.imageCentro1)

        fun bind(centrosComercialesModel:CentrosComerciales){

            ccNombre.text=centrosComercialesModel.nombre
            ccDireccion.text=centrosComercialesModel.ubicacion
            ccTiendas.text=centrosComercialesModel.tiendas
            Glide.with(itemView.context).load(centrosComercialesModel).into(ccImage)

            itemView.setOnClickListener{
                onClick(centrosComercialesModel)
            }
        }
    }
}