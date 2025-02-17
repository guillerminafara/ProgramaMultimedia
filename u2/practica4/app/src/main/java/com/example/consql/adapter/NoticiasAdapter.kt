package com.example.consql.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.consql.Clases.NewsEntity
import com.example.consql.Clases.NewsProvider.Companion.newsEntitiesList

import com.example.consql.R

class NoticiasAdapter(
    private var newsEntitiesList: MutableList<NewsEntity>,
    private val onClick: (NewsEntity) -> Unit,
    private val onLongClick: (NewsEntity) -> Unit,
    private val idUser: Int,
    private val insertLikes: (Int, Int) -> Unit,
    private val removeLikes: (Int, Int) -> Unit,
    private val checkedLikes: (Int, Int, CheckBox) -> Unit
) :
    RecyclerView.Adapter<NoticiasAdapter.NoticiaHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiaHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NoticiaHolder(layoutInflater.inflate(R.layout.news_activity, parent, false))
    }


    override fun getItemCount(): Int {
        return newsEntitiesList.size
    }

    fun removeItem(news: NewsEntity) {
        val position = newsEntitiesList.indexOf(news)
        if (position != -1) {
            newsEntitiesList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun onBindViewHolder(holder: NoticiaHolder, position: Int) {
        val item = newsEntitiesList[position]
        return holder.bind(item, idUser)
    }

    companion object {
        fun updateData(newList: MutableList<NewsEntity>) {
            newsEntitiesList = newList
//        notifyDataSetChanged()
        }
    }

    inner class NoticiaHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardNoticia = view.findViewById<CardView>(R.id.cardd)
        val tituloNoticia = view.findViewById<TextView>(R.id.titulo)
        val resumenNoticia = view.findViewById<TextView>(R.id.resumen)
        val fechaNoticia = view.findViewById<TextView>(R.id.fecha)
        val imagenNoticia = view.findViewById<ImageView>(R.id.imagen)
        val like = view.findViewById<CheckBox>(R.id.like)

        fun bind(noticiasModel: NewsEntity, idUser: Int) {

            val id = noticiasModel.id
            checkedLikes(idUser, id, like)
            tituloNoticia.text = noticiasModel.titulo
            resumenNoticia.text = noticiasModel.resumen
            fechaNoticia.text = noticiasModel.fecha
            Glide.with(itemView.context).load(noticiasModel.imagen).into(imagenNoticia)
            cardNoticia.setOnClickListener {
                onClick(noticiasModel)
            }
            cardNoticia.setOnLongClickListener {
                onLongClick(noticiasModel)
                true
            }
            like.setOnClickListener {

                    if (like.isChecked) {
                        Log.d("Likes", "idNoticias: ${id}, ${idUser}")
                        insertLikes(idUser, id)
                    } else {
                        removeLikes(idUser, id)
                    }

            }
        }

    }


//
//
//    companion object {
//    fun add(newsDao:NewsDao) {
//        newsDao.addNotice()
////        notifyDataSetChanged()
////        notifyItemInserted(listaNoticias.size - 1)
//    }
//}

}


