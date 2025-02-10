package com.example.consql.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.consql.Clases.NoticeEntity
import com.example.consql.Clases.NoticeProvider.Companion.listaNoticiaEntities

import com.example.consql.R

class NoticiasAdapter(private val listaNoticiaEntities:MutableList<NoticeEntity>,
                      private val onClick: (NoticeEntity) -> Unit):
    RecyclerView.Adapter<NoticiasAdapter.NoticiaHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiaHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return NoticiaHolder(layoutInflater.inflate(R.layout.noticias_activity, parent, false))
    }


    override fun getItemCount(): Int {
        return listaNoticiaEntities.size
    }

    override fun onBindViewHolder(holder: NoticiaHolder, position: Int) {
        val item=listaNoticiaEntities[position]
        return holder.bind(item)
    }

    inner class NoticiaHolder(view: View): RecyclerView.ViewHolder(view){
        val cardNoticia=view.findViewById<CardView>(R.id.cardd)
        val tituloNoticia=view.findViewById<TextView>(R.id.titulo)
        val resumenNoticia= view.findViewById<TextView>(R.id.resumen)
        val fechaNoticia=view.findViewById<TextView>(R.id.fecha)
        val imagenNoticia=view.findViewById<ImageView>(R.id.imagen)

        fun bind(noticiasModel: NoticeEntity,){
            tituloNoticia.text=noticiasModel.titulo
            resumenNoticia.text=noticiasModel.resumen
            fechaNoticia.text=noticiasModel.fecha
            Glide.with(itemView.context).load(noticiasModel.imagen).into(imagenNoticia)
            cardNoticia.setOnClickListener{
                onClick(noticiasModel)
            }
        }
    }


    companion object {
    fun add(noticiaEntity: NoticeEntity) {
        listaNoticiaEntities.add(noticiaEntity)
//        notifyDataSetChanged()
//        notifyItemInserted(listaNoticias.size - 1)
    }
}


}