package ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.elsda.tierramedia_pac.R

class EligeOpcion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elige_opcion)

        // Buscamos los botones de la Activity
        val btnNuevoRegistro = findViewById<Button>(R.id.btnNuevoRegistro)
        val btnVerCenso = findViewById<Button>(R.id.btnVerCenso)
        val btnVerProfesiones = findViewById<Button>(R.id.btnVerProfesiones)
        val btnAtras = findViewById<ImageButton>(R.id.btnAtrasEligeOpcion)

        // Añadimos el listener para el botón NuevoRegistro
        btnNuevoRegistro.setOnClickListener {
            // Crea un Intent para iniciar NuevoRegistro
            val intent = Intent(this, NuevoRegistro::class.java)
            startActivity(intent)
        }

        // Añadimos el listener para el botón Ver Censo por razas
        btnVerCenso.setOnClickListener {
            // Crea un Intent para iniciar EligeRaza
            val intent = Intent(this, EligeRaza::class.java)
            startActivity(intent)
        }

        // Añadimos el listener para el botón Ver Profesiones
        btnVerProfesiones.setOnClickListener {
            //TODO crear el intent para iniciar VerProfesiones
            val intent= Intent (this,VerProfesiones::class.java)
            startActivity(intent)
        }

        // Añadimos el listener para volver a la Activity anterior
        btnAtras.setOnClickListener {
            // Cierra la Activity actual => cierra esta Activity y vuelva a la anterior en la pila
            finish()
        }

    }
}