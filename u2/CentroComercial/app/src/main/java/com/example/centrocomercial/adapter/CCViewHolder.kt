package com.example.centrocomercial.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.centrocomercial.Clases.centrosComerciales
import com.example.centrocomercial.R

class CCViewHolder(view:View):RecyclerView.ViewHolder(view){
    val ccTitulo=view.findViewById<TextView>(R.id.titulo)
    val ccDireccion=view.findViewById<TextView>(R.id.direccion)
    val ccTiendas=view.findViewById<TextView>(R.id.tiendas1)
    val ccImage= view.findViewById<ImageView>(R.id.ImagenCentro1)


    fun render(centrosComerciales: centrosComerciales){
        ccTitulo.text=centrosComerciales.nombre
        ccDireccion.text=centrosComerciales.ubicacion
        ccTiendas.text=centrosComerciales.tiendas

    }
    fun imagen(imagen: ImageView, linnk: String){
        Glide.with(ccImage.context).load(linnk).into(ccImage)

    }
}