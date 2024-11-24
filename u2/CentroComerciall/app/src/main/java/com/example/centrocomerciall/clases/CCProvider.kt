package com.example.centrocomerciall.clases

class CCProvider (){
    companion object{
        val centrosList=listOf<CentrosComerciales>(
            CentrosComerciales(1,"Nuevo Centro","Av. de Pius XII, 2, Campanar,València", "250 tiendas","https://www.lovevalencia.com/wp-content/uploads/2012/01/Nuevo-centro.jpg",
            listaTiendas =listOf(
                Tienda(
                    "100 Montaditos",
                    "actividad: Hostelería\n ubicación: Planta superior\n Tel.: 963404372\n"
                ),
                Tienda(
                    "Primor",
                    "Perfumeria, venta de cosmetica, cuidado capilar y corporal, maquillaje"
                ),
                Tienda("Mango", "Tienda textil, Confección. Moda."),
                Tienda("Springfield", "Tienda de ropa ")
            )
        ),
            CentrosComerciales(2,"El Saler","Av. del Professor López Piñero, 16","160 tiendas","https://estaticos-cdn.prensaiberica.es/clip/d86ace57-dea1-4766-b6ac-f5e3ebffd012_16-9-discover-aspect-ratio_default_0.jpg",
                listOf(Tienda("Primor", "Perfumeria, venta de cosmetica, cuidado capilar y corporal, maquillaje" ),
                    Tienda("Belros", "Vendemos caramelos, golosinas, frutos secos y aceitunas además de tartas de gominolas y otros artículos exclusivos."),
                    Tienda("C&A","Moda para toda la familia. Prendas cómodas y elegantes para hombres y mujeres. Tendencias vanguardistas y atrevidas en los departamentos dedicados a los jóvenes. Diseños divertidos y prácticos para los más pequeños. C&A piensa en toda la familia."),
                    Tienda("Calzedonia","venta de pantys y medias para mujer y niña, y de calcetines y bañadores tanto para mujer como para hombre y niño/a")
                )),
            CentrosComerciales(3, "Bonaire", "Autovía del Este, Km. 345, Valencia", "123 tiendas","https://brainsre.news/wp-content/uploads/2024/10/GALERIA_Centro-Comercial-Bonaire_arf_3399.jpg",
                listOf(Tienda("Alcampo", "Alcampo es uno de los hipermercados referencia en España con precios muy competitivos y productos de primera calidad en todas las secciones, donde los clientes pueden realizar sus compras cada día."),
                    Tienda("Bershka", "Bershka es una marca de Grupo Inditex dirigida  a jóvenes atrevidos, conocedores de las últimas tendencias e interesados en la música, las redes sociales y las nuevas tecnologías."),
                    Tienda("Boston", "Boston, tienda de moda de gran referencia para todos los clientes masculinos que buscan prendas de vestir de calidad para poder ir a la moda en todo momento."),
                    Tienda("Decathlon", "Amantes del deporte, bienvenidos a vuestro paraíso. Decathlon es una empresa dedicada a la venta de ropa, complementos y artículos deportivos para hacer accesible el deporte al mayor número de personas posible.")

                )),
            CentrosComerciales(4, "El Manar", "Plaça Industrial el Manar, 3, València", "17 tiendas","https://elmanar.es/wp-content/uploads/2021/04/IMG-0052-scaled-e1673259378339.jpg",
                listOf(Tienda("Intersport","desde INTERSPORT te ayudamos a conseguir el mejor calzado para disfrutar al máximo del deporte."),
                    Tienda("Merkal", "Merkal Calzados, líder especialista en calzado y complementos para toda la familia. Calidad y moda Made in Spain para mujer, hombre, niño y niña"),
                    Tienda("Fifty Factory","Fifty Factory es la cadena del Grupo Cortefiel dedicada a la venta de prendas outlet y de su marca propia Milano."),
                    Tienda("Pepco", "PEPCO es una cadena internacional minorista y de moda con cerca de 2500 tiendas en Europa.  Ofrecemos una gran variedad de productos para el hogar y para la familia a los mejores precios. ")
                )))
    }
}