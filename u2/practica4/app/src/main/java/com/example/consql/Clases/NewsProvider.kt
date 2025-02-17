package com.example.consql.Clases

class NewsProvider() {
    companion object {

        var newsEntitiesList =mutableListOf(
            NewsEntity(
                id = 1,
                titulo = "Un estudio de 2019 alertaba del elevado riesgo de arrastre de coches en la rambla del Poyo",
                resumen = "En países desarrollados la mayoría de las víctimas por riadas está relacionada con coches, por intento de rescate o conducción en condiciones peligrosas, o bien con las denominadas 'avenidas relámpago'",
                fecha = "Jueves, 28 noviembre 2024 - 10:05",
                imagen = "https://phantom-elmundo.unidadeditorial.es/3f56424c8c5018907d6d0a81d2fda577/resize/920/f/webp/assets/multimedia/imagenes/2024/11/28/17327844185088.jpg",
                enlace = "https://www.elmundo.es/comunidad-valenciana/2024/11/28/674831b9fc6c832d388b45a4.html",
                idUser = 1
            ),
            NewsEntity(
                id = 2,
                titulo = "El Gobierno andaluz descarta retirar las subvenciones a UGT-A pese a la condena por el saqueo de los fondos públicos para los parados",
                resumen = "UGT-A guarda silencio sobre la condena por el fraude con las subvenciones y Pepe Álvarez se queja de que se conociera en pleno congreso del sindicato",
                fecha = "Jueves, 28 noviembre 2024 - 20:19",
                imagen = "https://phantom-elmundo.unidadeditorial.es/265b76fd473de910ea208aa3c036d375/crop/1x0/3071x2047/resize/540/f/webp/assets/multimedia/imagenes/2024/11/28/17328214160069.jpg",
                enlace = "https://www.elmundo.es/andalucia/2024/11/28/674842a7fdddffc0ad8b456e.html?intcmp=masnoticiasportada",
                idUser = 1
            ),
            NewsEntity(
                id = 3,
                titulo = "Una nutria se pasea por las calles de Avilés, muerde a un hombre y acaba retenida por la policía local en un banco",
                resumen = "Los agentes la mantuvieron en una sucursal bancaria hasta que llegaron los miembros del Seprona",
                fecha = "Viernes, 29 noviembre 2024 - 09:24",
                imagen = "https://phantom-elmundo.unidadeditorial.es/7e201098416357165f30c17c23d6e10d/resize/540/f/webp/assets/multimedia/imagenes/2024/11/29/17328684993276.jpg",
                enlace = "https://www.elmundo.es/espana/2024/11/29/6749733efdddff0ea98b4590.html",
                idUser = 1)
//            ),
//            NewsEntity(
//                id = 4,
//                titulo = "DANA Valencia: objetivos y consecuencias de las narrativas desinformativas que han circulado en redes",
//                resumen = "a DANA que devastó varios municipios de Valencia el 29 de octubre deja ya 222 muertos. A esta tragedia sin precedentes se ha sumado la propagación de narrativas desinformativas que han minado la confianza de la ciudadanía en las autoridades y que tiene consecuencias reales para los miles de damnificados por esta catástrofe. Los bulos que hemos detectado van desde las falsas alertas de las primeras horas, a las teorías conspirativas sobre las causas, pasando por las invenciones acerca de los muertos y desaparecidos, o las falacias que a día de hoy seguimos detectando en relación con las ayudas a las víctimas",
//                fecha = "29/11/2024 | 10:16 horas",
//                imagen = "https://img2.rtve.es/i/?w=1600&i=01732841846238.jpg",
//                enlace = "https://www.rtve.es/noticias/20241129/dana-valencia-objetivos-consecuencias-narrativas-desinformativas-redes/16351634.shtml"
//            ),
//            NewsEntity(
//                id = 5,
//                titulo = " El precio de los carburantes sigue al alza y regresa a niveles de septiembre",
//                resumen = "El diésel sube hasta los 1,420 euros por litro y el de la gasolina continúa en los 1,510 euros\n" +
//                        "Ambos combustibles se mantienen por debajo de los precios medios europeos",
//                fecha = "28/11/2024 | 18:56 horas",
//                imagen = "https://img2.rtve.es/i/?w=1600&i=01732814678661.jpg",
//                enlace = "https://www.rtve.es/noticias/20241128/precio-carburantes-alza-maximos-desde-septiembre/16351278.shtml"
//            ),
//            NewsEntity(
//                id = 6,
//                titulo = " Black Friday, un fenómeno \"mal situado en el calendario\" para las empresas en España: \"Venden mucho, pero facturan poco\"",
//                resumen = "Muchas marcas se suman a esta 'fiesta' del consumo por \"miedo a quedarse fuera\", según los expertos\n" +
//                        "Todo apunta a que \"tiene bastante futuro\" en España, pero hay factores que podrían frenar su impulso en los próximos años",
//                fecha = "29/11/2024 | 07:38 horas ",
//                imagen = "https://img2.rtve.es/i/?w=1600&i=01732214457713.jpg",
//                enlace = "https://www.rtve.es/noticias/20241129/black-friday-espana-retos-empresas-navidades/16338965.shtml"
//            ),
//            NewsEntity(
//                id = 7,
//                titulo = "El SEPE alerta: sancionará a los parados que compatibilicen el nuevo subsidio con estos trabajos",
//                resumen = "El SEPE iniciará un procedimiento sancionador contra aquellos que no comuniquen los cambios que afecten a la ayuda",
//                fecha = "29.11.2024 10:45",
//                imagen = "https://fotografias.larazon.es/clipping/cmsimages02/2022/09/02/35AACB5B-96E5-473C-AC90-CCB1EC57F28D/97.jpg?crop=3822,2150,x0,y199&width=1600&height=900&optimize=low&format=webply",
//                enlace = "https://www.larazon.es/economia/sepe-esta-alerta-sancionara-parados-que-compatibilicen-nuevo-subsidio-estos-trabajos_2024112967498d407337f20001afb935.html"
//            ),
//            NewsEntity(
//                id = 8,
//                titulo = "El metro de Valencia recuperará el servicio el próximo martes 3 de diciembre",
//                resumen = "Se recupera de forma total en las línes 3, 5 y 9",
//                fecha = " 29.11.2024 11:23",
//                imagen = "https://fotografias.larazon.es/clipping/cmsimages01/2024/11/27/FEF9150D-E4C4-45F4-8DCD-CEB64216A257/97.jpg?crop=5150,2897,x0,y280&width=1600&height=900&optimize=low&format=webply",
//                enlace = "https://www.larazon.es/comunidad-valenciana/metro-valencia-recuperara-servicio-proximo-martes-3-diciembre_202411296749963b85d24c0001ca4936.html"
//            ),
//            NewsEntity(
//                id = 9,
//                titulo = "Las pensiones subirán en torno a un 2,8% en 2025",
//                resumen = "La revalorización será de casi 600 euros adicionales al año para una pensión media de jubilación",
//                fecha = "28.11.2024 09:03",
//                imagen = "https://fotografias.larazon.es/clipping/cmsimages02/2021/07/02/966D403D-60D7-4CD6-AF29-6A187E2ED141/97.jpg?crop=6720,3780,x0,y355&width=1600&height=900&optimize=low&format=webply",
//                enlace = "https://www.larazon.es/economia/pensiones-subiran-torno-28-2025_20241128674823c47337f20001ae55fe.html"
//            ), NewsEntity(
//                id = 10,
//                titulo = "Un revés inesperado para Ucrania: tira a la basura 100.000 proyectiles de mortero que estaban defectuosos",
//                resumen = "La munición, que es clave para Kiev en esta fase de la guerra, se compró a un fabricante nacional para reducir la dependiencia de Occidente",
//                fecha = "29.11.2024 09:09",
//                imagen = "https://fotografias.larazon.es/clipping/cmsimages02/2024/11/21/705DBB67-398C-46D2-9CAE-FE2C8E52F68D/97.jpg?crop=5000,2813,x0,y279&width=1600&height=900&optimize=low&format=webply",
//                enlace = "https://www.larazon.es/internacional/reves-inesperado-ucrania-tira-basura-100000-proyectiles-mortero-que-estaban-defectuosos_20241129674976bc85d24c0001ca2b3f.html"
//            )

        )
    }

}