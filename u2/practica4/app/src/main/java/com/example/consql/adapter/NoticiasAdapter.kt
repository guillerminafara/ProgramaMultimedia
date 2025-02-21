package com.example.consql.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.consql.Clases.FavoriteEntity
import com.example.consql.Clases.NewsEntity
import com.example.consql.Clases.NewsProvider.Companion.newsEntitiesList

import com.example.consql.R
import com.example.consql.consultas.UserApplication
import com.google.android.material.checkbox.MaterialCheckBox
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class NoticiasAdapter(
    private var newsEntitiesList: MutableList<NewsEntity>,
    private val onClick: (NewsEntity) -> Unit,
    private val onLongClick: (NewsEntity) -> Unit,
    private val idUser: Int,
    private val onLikeClick: (NewsEntity, Boolean) -> Unit,
//    private val lifecycleScope: CoroutineScope,
//    private val insertLikes: (Int, Int) -> Unit,
//    private val removeLikes: (Int, Int) -> Unit,
    private val checkedLikes: (Int, Int, CheckBox) -> Unit,
//    private val fav: MaterialCheckBox,
//    private var newsFavoritesList: MutableList<FavoriteEntity>,
//    param: (Int, Int, ()-> Unit) -> Unit
) :RecyclerView.Adapter<NoticiasAdapter.NoticiaHolder>() {

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
//    fun favoriteLayout(idUser: Int, idNews:Int){
//        fav.setOnClickListener{
//            if(fav.isChecked){
//                val listFavorites = mutableListOf<NewsEntity>()
//                newsEntitiesList.forEach { e ->
//                    newsFavoritesList.forEach { r ->
//                        if (e.id == r.noticeId){
//                            listFavorites.add(e)
//                        }
//                    }
//                }
//                newsEntitiesList = listFavorites
//
//                notifyDataSetChanged()
//            }else{
//
//            }
////            lifecycleScope.launch(Dispatchers.IO) {
////                val favs= UserApplication.database.newsUserDao().getFavoriteByID(idUser = idUser, idNews=idNews )
////                notify()
////            }
//        }
//    }

    override fun onBindViewHolder(holder: NoticiaHolder, position: Int) {
        val item = newsEntitiesList[position]
        return holder.bind(item)//, idUser
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

        fun bind(noticiasModel: NewsEntity ) {//idUser: Int
            val id = noticiasModel.id
//            checkedLikes(idUser, id, like)
            tituloNoticia.text = noticiasModel.titulo
            resumenNoticia.text = noticiasModel.resumen
            fechaNoticia.text = noticiasModel.fecha
            Glide.with(itemView.context).load(noticiasModel.imagen).into(imagenNoticia)
            checkedLikes(idUser, id, like)
            cardNoticia.setOnClickListener {
                onClick(noticiasModel)
            }
//            favoriteLayout(idUser,id)
            cardNoticia.setOnLongClickListener {
                onLongClick(noticiasModel)
                true
            }
            like.setOnClickListener{

                if(like.isChecked){
                    checkedLikes(idUser, id, like)
                }
//            like.setOnCheckedChangeListener()  {_, isChecked->//setOnClickListener
                onLikeClick(noticiasModel, like.isChecked)
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


