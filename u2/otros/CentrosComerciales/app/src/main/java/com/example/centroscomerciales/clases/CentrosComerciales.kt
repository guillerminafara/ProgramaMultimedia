package com.example.centroscomerciales.clases

data class CentrosComerciales (val id: Int, val nombre : String,
                          val ubicacion :String,
                          val tiendas: String,
                          val url:String,
                          val listaTiendas: List<Tienda> =listOf()
)