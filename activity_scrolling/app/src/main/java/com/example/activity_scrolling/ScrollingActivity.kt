package com.example.activity_scrolling

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.activity_scrolling.databinding.ActivityScrollingBinding
import android.widget.Button

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var url: String="";
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var imagen1: ImageView = findViewById(R.id.Imagen1)
        var linnk = "https://i.blogs.es/13b8c5/piratascaribe/1366_2000.jpg"
        imagen(binding.Imagen1, linnk)

        imagen(
            binding.Imagen2,
            "https://static1.cbrimages.com/wordpress/wp-content/uploads/2023/11/inside-out-2-custom-images-1-1.jpg?q=70&fit=crop&w=1140&h=&dpr=1"
        )

        imagen(
            binding.Imagen3,
            "https://teamupmedia.es/wp-content/uploads/2022/12/el-gato-con-botas-el-ultimo-deseo-poster-2-1671012941.jpg"
        )
        imagen(
            binding.Imagen4,
            "https://s3.amazonaws.com/rtvc-assets-senalcolombia.gov.co/s3fs-public/styles/imagen_noticia/public/field/image/pelicula-princesa-monoke-portada.jpg?itok=enoxC05B"
        )

        var boton: Button = findViewById(R.id.Boton1)

        url = "https://es.wikipedia.org/wiki/Piratas_del_Caribe"
        botones(binding.Boton1, url)
        botones(binding.Boton2, "https://es.wikipedia.org/wiki/Inside_Out_2" )
        botones(binding.Boton3, "https://es.wikipedia.org/wiki/El_Gato_con_Botas:_el_%C3%BAltimo_deseo")
        botones(binding.Boton4,"https://es.wikipedia.org/wiki/La_princesa_Mononoke")
    }
    fun imagen(imagen:ImageView, linnk: String){
        Glide.with(this).load(linnk).into(imagen)
    }

    fun botones(boton:Button, url:String){
        boton.setOnClickListener{
            val uri: Uri= Uri.parse(url)
            val intent=  Intent(Intent.ACTION_VIEW, uri )
            //intent.data= Uri.parse(url)
            startActivity(intent)
        }
    }
}