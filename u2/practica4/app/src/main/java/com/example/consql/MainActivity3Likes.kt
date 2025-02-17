package com.example.consql

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.consql.Clases.NewsEntity
import com.example.consql.adapter.NoticiasAdapter
import com.example.consql.consultas.UserApplication

import com.example.consql.databinding.ActivityMainActivity3LikesBinding
import kotlinx.coroutines.launch

class MainActivity3Likes : AppCompatActivity() {
    private lateinit var newsList: MutableList<NewsEntity>
    private lateinit var adapter: NoticiasAdapter
    private lateinit var binding: ActivityMainActivity3LikesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainActivity3LikesBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
    }

//    fun recycler() {
//        lifecycleScope.launch {
//            val recyclerView = findViewById<RecyclerView>(R.id.recyclerMain3)
//            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity3Likes)
//
//            newsList = UserApplication.database.newsDao().getAllNotice()
//            adapter = NoticiasAdapter(newsList,
//                onClick = { noticia ->
//                    val uri: Uri = Uri.parse(noticia.enlace)
//                    val intent = Intent(Intent.ACTION_VIEW, uri)
//                    Log.d("NEWSSS", " not EMPTY newsList")
//                    startActivity(intent)
//                },
//                onLongClick = { noticia -> deleteNews(noticia) })// para hacer quitar de favoritos.
//            recyclerView.adapter = adapter
//        }
//    }
//
//    fun getFavorites(){
//        newsList = UserApplication.database.newsUserDao().getFavoriteByID()
//    }

}