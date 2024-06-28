package ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import bbdd.HabitantesSQLite
import com.elsda.tierramedia_pac.R
import com.elsda.tierramedia_pac.habitantes.Censo
import com.elsda.tierramedia_pac.habitantes.HabitanteTierraMedia
import com.google.android.material.snackbar.Snackbar

class NuevoRegistro : AppCompatActivity() {

    /**
     * Método que nos devuelve un HabitanteTierraMedia aleatorio
     */
    private fun getNuevoHabitante(): HabitanteTierraMedia {
        val razas = arrayOf("Elfo", "Enano", "Hobbit", "Hombre")
        val razaElegida = razas.random()
        val habitanteTierraMedia = Censo().generarHabitante(razaElegida)

        return habitanteTierraMedia
    }

    /**
     * Método para obtener la cadena con el formato que necesitamos para el EditText
     */
    private fun getTextResumenHabitante(
        nombre: String, apellidos: String, edad: Int,
        raza: String, ubicacion: String, profesion: String
    ): String {
        var cadena = "Nombre: $nombre\nApellidos: $apellidos\nEdad: ${edad.toString()}\n"
        cadena += "Raza: $raza\nUbicación: $ubicacion\nProfesion: $profesion"

        return cadena;
    }

    /**
     * Función que muestra los datos de un Nuevo Habitante de la Tierra Media
     */
    private fun verNuevoHabitante(habitante: HabitanteTierraMedia) {
        // Asignamos el EditText a una variable
        val editTextResumenHabitante = findViewById<EditText>(R.id.txtResumenHabitante)
        // Preparamos la cadena resumen del nuevo habitante de la Tierra Media
        val cadenaResumen = getTextResumenHabitante(
            habitante.nombre, habitante.apellidos,
            habitante.edad, habitante.raza, habitante.ubicacion, habitante.profesion
        )
        // Asignamos la cadena al editText
        editTextResumenHabitante.setText(cadenaResumen)
    }

    /**
     * Método para cuando se crea la Activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_registro)

        // Buscamos los botones de esta
        val btnActualizarDatos = findViewById<Button>(R.id.btnActualizarDatos)
        val btnInsertarRegistro = findViewById<Button>(R.id.btnInsertarEnCenso)
        val btnAtras = findViewById<ImageButton>(R.id.btnAtrasNuevoRegistro)

        // Variable para el uso de la base de datos
        val dbHabitantes = HabitantesSQLite(this)

        // Tenemos los datos de un nuevo habitante al crear la Activity => lo mostramos
        // OJO => usamos var porque vamos a necesitar cambiar la variable en ActualizarDatos
        var nuevoHabitante = getNuevoHabitante()
        verNuevoHabitante(nuevoHabitante)

        // Añadimos el listener para volver a la Activity anterior
        btnAtras.setOnClickListener {
            // Cierra la Activity actual => cierra esta Activity y vuelva a la anterior en la pila
            finish()
        }

        /**
         * Si actualizamos los datos => tenemos un nuevo habitante
         */
        btnActualizarDatos.setOnClickListener {
            nuevoHabitante = getNuevoHabitante()
            verNuevoHabitante(nuevoHabitante)
        }

        /**
         * Insertamos el nuevo habitante en la base de datos
         */
        btnInsertarRegistro.setOnClickListener {
            // Insertar nuevo habitante
            dbHabitantes.insertarHabitante(nuevoHabitante)
            // Mostramos la información de insertar nuevo habitante
            Snackbar.make(
                findViewById(android.R.id.content),
                "Nuevo habitante registrado",
                Snackbar.LENGTH_SHORT
            ).setDuration(1000).show() // 1000 ms = 1 segundo
            // Actualizamos los datos con un nuevo habitante
            nuevoHabitante = getNuevoHabitante()
            verNuevoHabitante(nuevoHabitante)
        }
    }
}