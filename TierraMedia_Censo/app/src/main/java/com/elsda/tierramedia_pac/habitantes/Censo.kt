package com.elsda.tierramedia_pac.habitantes

import kotlin.random.Random

/**
 * Clase Censo, la cual nos permite generar un habitante de la Tierra Media de forma aleatoria
 */
class Censo {

    private fun getHombreOMujer(): Int {
        // Genera un número aleatorio: 0 o 1, 0 => hombre, 1 => mujer
        return Random.nextInt(0, 2)
    }

    /**
     * Función para generar un HabitanteTierraMedia con datos aleatorios de las diferentes razas
     */
    fun generarHabitante(raza: String): HabitanteTierraMedia {

        // Asignación de Ser basada en la raza, lanzar excepción si la raza es desconocida
        val ser = when (raza) {
            "Elfo" -> Elfo()
            "Enano" -> Enano()
            "Hombre" -> Hombre()
            "Hobbit" -> Hobbit()
            else -> throw IllegalArgumentException("Raza desconocida: $raza")
        }
        // Hombre (0) o mujer (1)
        val esMujer = getHombreOMujer()
        // Asignación de nombre, apellidos y ubicación usando polimorfismo
        val nombre =
            if (esMujer == 0) ser.nombresMasculinos.random() else ser.nombresFemeninos.random()
        val apellidos = ser.apellidos.random()
        val ubicacion = ser.ubicaciones.random()
        // Edad aleatoria ente 18 y 75
        val edad = Random.nextInt(18, 76)
        // La profesión dentro del array de profesiones
        val profesion = Profesion().profesiones.random()

        return HabitanteTierraMedia(nombre, apellidos, edad, raza, ubicacion, profesion)
    }

}
