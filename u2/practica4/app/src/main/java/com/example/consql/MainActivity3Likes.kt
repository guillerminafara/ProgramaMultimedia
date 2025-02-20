package com.example.consql

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.consql.Clases.NewsEntity
import com.example.consql.Clases.UserEntity
import com.example.consql.adapter.NoticiasAdapter
import com.example.consql.consultas.UserApplication

import com.example.consql.databinding.ActivityMainActivity3LikesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity3Likes : AppCompatActivity() {
    private var newsList: MutableList<NewsEntity> = mutableListOf()
    private lateinit var adapter: NoticiasAdapter
    private lateinit var binding: ActivityMainActivity3LikesBinding
    val customScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val user = intent.getParcelableExtra<UserEntity>("USER")
        binding = ActivityMainActivity3LikesBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        favList()
        recycler()

        atras()
        newsActivitys()
    }

    fun recycler() {
        val user = intent.getParcelableExtra<UserEntity>("USER")
        lifecycleScope.launch {
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerMain3)
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity3Likes)
            adapter = NoticiasAdapter(
                newsList,
                onClick = { noticia ->
                    val uri: Uri = Uri.parse(noticia.enlace)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    Log.d("NEWSSS", " not EMPTY newsList")
                    startActivity(intent)
                },
                onLongClick = { noticia -> deleteFav(noticia.id) },
                user?.id!!
            )
            recyclerView.adapter = adapter
        }
    }
    fun favList(){
        val user = intent.getParcelableExtra<UserEntity>("USER")
        Log.d("pag3", "${user?.id}")
        lifecycleScope.launch {
            val favorites = user?.id?.let {
                UserApplication.database.newsUserDao().getFavoriteNews(
                    it
                )
            }
            newsList.clear()
            if (favorites != null) {
                newsList.addAll(favorites)
            }
            adapter.notifyDataSetChanged()
        }
    }
    fun atras(){
        binding.atras.setOnClickListener{
            val user = intent.getParcelableExtra<UserEntity>("USER")
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("USER", user)
            startActivity(intent)
            finish()
        }
    }
    fun newsActivitys(){
        val user = intent.getParcelableExtra<UserEntity>("USER")
        binding.News.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("USER", user)
            startActivity(intent)
            finish()
        }
    }

    fun deleteFav(idNews:Int) {
        val user = intent.getParcelableExtra<UserEntity>("USER")
        lifecycleScope.launch {
            val favorite= UserApplication.database.newsUserDao().getFavoriteByID(user?.id!!, idNews)

            UserApplication.database.newsUserDao().deleteFavorite(favorite)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        lifecycleScope.cancel() // 🔹 Cancela cualquier operación pendiente en coroutines
    }
}

//
//    fun getFavorites(){
//        newsList = UserApplication.database.newsUserDao().getFavoriteByID()
//    }
//    fun checkedLikes(idUser: Int, id: Int, like: CheckBox) {
//        lifecycleScope.launch(Dispatchers.IO) {
//            val likesEntity = UserApplication.database.newsUserDao().getFavoriteByID(idUser, id)
//
//            if (likesEntity != null) {
//                like.isChecked = true
//            }
//
//
//        }
//}