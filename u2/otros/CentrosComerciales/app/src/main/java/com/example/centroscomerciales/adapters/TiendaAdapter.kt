package com.example.centroscomerciales.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.example.centroscomerciales.R
import com.example.centroscomerciales.clases.CentrosComerciales
import com.example.centroscomerciales.clases.Tienda

class TiendaAdapter(private val tiendaList: List<Tienda>) :
    RecyclerView.Adapter<TiendaAdapter.TiendaViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TiendaAdapter.TiendaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TiendaViewHolder(layoutInflater.inflate(R.layout.tiendas, parent, false))
    }

    override fun onBindViewHolder(holder: TiendaAdapter.TiendaViewHolder, position: Int) {
        val item = tiendaList[position]
        return holder.bind(item)
    }

    override fun getItemCount(): Int {
        return tiendaList.size
    }

    inner class TiendaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tiendaNombre = view.findViewById<TextView>(R.id.idNombre)
        val tiendaDescripcion = view.findViewById<TextView>(R.id.idDescripcion)
        val tiendaImage= view.findViewById<ImageView>(R.id.image1)

        fun bind(centrosComercialesTienda: Tienda) {
            tiendaNombre.text = centrosComercialesTienda.nombre
            tiendaDescripcion.text = centrosComercialesTienda.descripcion
            Glide.with(itemView.context).load(centrosComercialesTienda.url).into(tiendaImage)
        }
    }

}