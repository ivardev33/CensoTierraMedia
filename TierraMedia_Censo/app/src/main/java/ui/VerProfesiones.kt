package ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import com.elsda.tierramedia_pac.R
import com.elsda.tierramedia_pac.habitantes.Profesion

class VerProfesiones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_profesiones)

        val spinner: Spinner = findViewById(R.id.spinProfesiones)
        val btnAtras = findViewById<ImageButton>(R.id.btnAtrasEligeProfesion)
        val btnListarProfesion = findViewById<Button>(R.id.btnListarProfesion)

        // Array con las opciones ordenadas alfabéticamente
        val opciones = Profesion().profesiones.sortedArray()
        var profesionSeleccionada = opciones[0] // Inicializamos con la primera profesión

        // Crear un ArrayAdapter usando el array de strings y un layout de spinner predeterminado
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        // Especificar el layout a usar cuando la lista de opciones aparezca
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Aplicar el adapter al spinner
        spinner.adapter = adapter

        // Establecer un listener para cuando se seleccione un elemento
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                // Haz algo con el item seleccionado
                Log.d("Spinner", "Seleccionado: ${opciones[position]}")
                profesionSeleccionada = opciones[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Otra opción, por si no se selecciona nada
            }
        }

        // Añadimos el listener para ir al listado de Profesiones
        btnListarProfesion.setOnClickListener {
            val intent = Intent(this, ListarProfesiones::class.java).apply {
                putExtra("PROFESION", profesionSeleccionada)
            }
            startActivity(intent)
        }

        // Añadimos el listener para volver a la Activity anterior
        btnAtras.setOnClickListener {
            // Cierra la Activity actual => cierra esta Activity y vuelva a la anterior en la pila
            finish()
        }

    }
}