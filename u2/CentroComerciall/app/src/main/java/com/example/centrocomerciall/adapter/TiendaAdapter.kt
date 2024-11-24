package com.example.centrocomerciall.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.WindowInsetsCompat.Type
import androidx.recyclerview.widget.RecyclerView
import com.example.centrocomerciall.R
import com.example.centrocomerciall.clases.CentrosComerciales
import com.example.centrocomerciall.clases.Tienda

class TiendaAdapter(
    private val tiendaList: List<Tienda>,
    private val onClick: (Tienda) -> Unit
) :
    RecyclerView.Adapter<TiendaAdapter.TiendaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TiendaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TiendaViewHolder(layoutInflater.inflate(R.layout.activity_main3, parent, false))
    }

    override fun getItemCount(): Int {
        return tiendaList.size
    }

    override fun onBindViewHolder(holder: TiendaViewHolder, position: Int) {
       val item = tiendaList[position]
        return holder.bind(item)
    }

    inner class TiendaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tiendaCard = view.findViewById<CardView>(R.id.idCard)
        val tiendaNombre = view.findViewById<TextView>(R.id.idNombre)
        val tiendaDescripcion = view.findViewById<TextView>(R.id.idDescripcion)

        fun bind(centrosComercialesTienda: Tienda) {
            tiendaNombre.text = centrosComercialesTienda.nombre
            tiendaDescripcion.text = centrosComercialesTienda.descripcion
            itemView.setOnClickListener {
                onClick(centrosComercialesTienda)
            }
        }
    }
}


