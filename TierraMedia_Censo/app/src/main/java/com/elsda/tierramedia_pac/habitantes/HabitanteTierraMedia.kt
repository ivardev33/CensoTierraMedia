package com.elsda.tierramedia_pac.habitantes

/**
 * Clase con los datos de un HabitanteTierraMedia para luego almacenar en la base de datos
 */
class HabitanteTierraMedia(
    val nombre: String,
    val apellidos: String,
    val edad: Int,
    val raza: String,
    val ubicacion: String,
    val profesion: String
)