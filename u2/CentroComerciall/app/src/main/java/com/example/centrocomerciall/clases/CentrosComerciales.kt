package com.example.centrocomerciall.clases

import java.io.Serializable

class CentrosComerciales (val id: Int, val nombre : String,
                          val ubicacion :String,
                          val tiendas: String,
                          val url:String,
                          val listaTiendas: List<Tienda> =listOf()
) : Serializable
//{
//
//    fun getCentrosPorId(id: Int): CentrosComerciales?= CentrosComerciales(id, nombre,ubicacion,tiendas, listOf(Tienda("Yuop", "af")))



//}


//companion object {
//    fun getCentrosPorId(id: Int): CentrosComerciales {
//        val Centro:CentrosComerciales= CCProvider.centrosList.get(id)
//        return Centro
//    }
//}
//
//}