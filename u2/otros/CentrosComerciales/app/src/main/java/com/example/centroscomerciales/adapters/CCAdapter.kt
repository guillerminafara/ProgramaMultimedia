package com.example.centroscomerciales.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.centroscomerciales.R
import com.example.centroscomerciales.clases.CentrosComerciales

class CCAdapter(private val centroList:List<CentrosComerciales>,
                private val funcion: (centroC:CentrosComerciales) -> Unit):
    RecyclerView.Adapter<CCAdapter.CCViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CCViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CCViewHolder(layoutInflater.inflate(R.layout.centros, parent, false))
    }



    override fun getItemCount(): Int {
       return centroList.size
    }

    override fun onBindViewHolder(holder: CCViewHolder, position: Int) {
        val item=centroList[position]
        return holder.bind(item, funcion)
    }


    inner class CCViewHolder(view: View):RecyclerView.ViewHolder(view){
        val ccCard= view.findViewById<CardView>(R.id.card1)
        val ccNombre=view.findViewById<TextView>(R.id.nombree)
        val ccDireccion=view.findViewById<TextView>(R.id.direccion)
        val ccTiendas=view.findViewById<TextView>(R.id.tiendas)
        val ccImage= view.findViewById<ImageView>(R.id.imageCentro1)

        fun bind(centrosComercialesModel: CentrosComerciales, funcion: (centroC: CentrosComerciales) -> Unit){
            ccNombre.text=centrosComercialesModel.nombre
            ccDireccion.text=centrosComercialesModel.ubicacion
            ccTiendas.text=centrosComercialesModel.tiendas

            Glide.with(itemView.context).load(centrosComercialesModel.url).into(ccImage)
            ccCard.setOnClickListener{
                funcion(centrosComercialesModel)
            }
        }

    }
}