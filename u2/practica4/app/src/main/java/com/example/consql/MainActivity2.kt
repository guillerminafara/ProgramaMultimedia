package com.example.consql


import android.content.Intent
import android.net.Uri

import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.consql.Clases.FavoriteEntity
import com.example.consql.Clases.NewsEntity
import com.example.consql.Clases.UserEntity
import com.example.consql.PrefHelper.PrefHelper
import com.example.consql.adapter.NoticiasAdapter
import com.example.consql.consultas.UserApplication


import com.example.consql.databinding.ActivityMain2Binding

import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var prefHelper: PrefHelper
    private lateinit var adapter: NoticiasAdapter
    private lateinit var newsList: MutableList<NewsEntity>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val user = intent.getParcelableExtra<UserEntity>("USER")
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        if (user != null) {
            Log.d(
                "SecondActivity",
                "Usuario: ${user.user}, Contraseña: ${user.pass}, IIIIIId ${user.id}"
            )
        }
        prefHelper = PrefHelper(this)
        val back = binding.atras
//        recyclerV()
        atras(back)
        noticia()
        agregarNoticia(binding.btnSave)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerMain2)
        recyclerView.layoutManager = LinearLayoutManager(this)
        lifecycleScope.launch {
            val user = intent.getParcelableExtra<UserEntity>("USER")
            newsList = UserApplication.database.newsDao().getAllNotice().toMutableList()
            adapter = NoticiasAdapter(newsList,
                onClick = { noticia ->
                    prefHelper.guardarString("ultimaNoticia", noticia.titulo)

                    val uri: Uri = Uri.parse(noticia.enlace)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    Log.d("NEWSSS", " not EMPTY newsList")
                    startActivity(intent)
                },
                onLongClick = { noticia -> deleteNews(noticia) },
                user?.id!!,
                { e, r -> insertLikes(e, r) },
                { e, r -> removeLikes(e, r) },
                { e, r, t -> checkedLikes(e, r, t) }
            )
            recyclerView.adapter = adapter
        }

    }

    fun cambioFavorites() {

        val user = intent.getParcelableExtra<UserEntity>("USER")
        val intent = Intent(this, MainActivity4News::class.java)
        intent.putExtra("USER", user)
        startActivity(intent)
    }

    fun deleteNews(news: NewsEntity) {
        AlertDialog.Builder(this)
            .setTitle("Eliminar Noticia")
            .setMessage("¿Seguro que quieres eliminar esta noticia?")
            .setPositiveButton("Sí") { _, _ ->
                lifecycleScope.launch {
                    withContext(Dispatchers.IO) {
                        UserApplication.database.newsDao().deleteNotice(news)
                    }
                    withContext(Dispatchers.Main) {
                        adapter.removeItem(news)
                        Toast.makeText(this@MainActivity2, "Noticia eliminada", Toast.LENGTH_SHORT)
                            .show()
                        //Toast.makeText(this@MainActivity2, "Noticia eliminada", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            .setNegativeButton("No", null)
            .show()
    }

    fun agregarNoticia(btnSave: FloatingActionButton) {
        btnSave.setOnClickListener {
            val user = intent.getParcelableExtra<UserEntity>("USER")
            val intent = Intent(this, MainActivity4News::class.java)
            intent.putExtra("USER", user)
            startActivity(intent)

        }
    }

    fun insertLikes(idUser: Int, id: Int) {
        lifecycleScope.launch {
            UserApplication.database.newsUserDao().addFavorite(FavoriteEntity(idUser, id))
        }
    }

    fun removeLikes(idUser: Int, id: Int) {
        lifecycleScope.launch {
            UserApplication.database.newsUserDao().deleteFavorite(FavoriteEntity(idUser, id))
        }
    }

    fun checkedLikes(idUser: Int, id: Int, like: CheckBox) {
        lifecycleScope.launch(Dispatchers.IO) {
            val likesEntity = UserApplication.database.newsUserDao().getFavoriteByID(idUser, id)

            if (likesEntity != null) {
                like.isChecked = true
            }


        }


    }

    fun noticia() {
        val nombre = prefHelper.getStrings("ultimaNoticia", "")
        if (nombre != "") {
            Toast.makeText(this, "$nombre", Toast.LENGTH_SHORT).show()
        }

    }

//    fun recyclerV() {
//        val linearLayout = LinearLayoutManager(this)
//
//        lifecycleScope.launch(Dispatchers.IO) {
//            withContext(Dispatchers.Main) {
//                var newsList = database.noticeDao().getAllNotice()
//                if (newsList != null) {
//                    binding.recyclerMain2.layoutManager = linearLayout
//                    binding.recyclerMain2.adapter = NoticiasAdapter(newsList)
//                    { noticia ->
//                        prefHelper.guardarString("ultimaNoticia", noticia.titulo)
//
//                        val uri: Uri = Uri.parse(noticia.enlace)
//                        val intent = Intent(Intent.ACTION_VIEW, uri)
//                        Log.d("NEWSSS", " not EMPTY newsList")
//                        startActivity(intent)
//
//                    }
//                } else {
//                    Log.d("USERR", "EMPTY newsList")
//                }
//            }
//        }
//    }

    //    fun load(): MutableList<NewsEntity>{
//       var newsList= mutableListOf<NewsEntity>()
//        lifecycleScope.launch(Dispatchers.IO) {
//            withContext(Dispatchers.Main) {
//             newsList = database.noticeDao().getAllNotice()
//            }
//        }
//        return newsList
//    }
    private fun mostrarDetalles(news: NewsEntity) {
        Toast.makeText(this, "Detalles de: ${news.titulo}", Toast.LENGTH_SHORT).show()
    }

    fun atras(atras: ImageView) {
        atras.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}
