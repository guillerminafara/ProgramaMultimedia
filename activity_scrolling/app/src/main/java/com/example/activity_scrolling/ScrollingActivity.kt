package com.example.activity_scrolling

import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.activity_scrolling.databinding.ActivityScrollingBinding

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var imagen1 : ImageView= findViewById(R.id.Imagen1)
        var linnk ="https://i.blogs.es/13b8c5/piratascaribe/1366_2000.jpg"
        imagen(binding.Imagen1, linnk)

        imagen(binding.Imagen2, "https://static1.cbrimages.com/wordpress/wp-content/uploads/2023/11/inside-out-2-custom-images-1-1.jpg?q=70&fit=crop&w=1140&h=&dpr=1")

        imagen(binding.Imagen3,"https://teamupmedia.es/wp-content/uploads/2022/12/el-gato-con-botas-el-ultimo-deseo-poster-2-1671012941.jpg" )
        imagen(binding.Imagen4, "https://s3.amazonaws.com/rtvc-assets-senalcolombia.gov.co/s3fs-public/styles/imagen_noticia/public/field/image/pelicula-princesa-monoke-portada.jpg?itok=enoxC05B")

    }
    fun imagen(imagen:ImageView, linnk: String){
        Glide.with(this).load(linnk).into(imagen)
    }
}