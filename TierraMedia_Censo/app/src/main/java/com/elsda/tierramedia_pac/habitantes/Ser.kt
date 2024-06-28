package com.elsda.tierramedia_pac.habitantes

/**
 * Clase Ser, es la clase padre de los diferentes seres de la Tierra Media
 */
abstract class Ser {
    abstract val nombresMasculinos: Array<String>
    abstract val nombresFemeninos: Array<String>
    abstract val apellidos: Array<String>
    abstract val ubicaciones: Array<String>
}