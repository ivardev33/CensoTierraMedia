package ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.elsda.tierramedia_pac.R

class EligeRaza : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elige_raza)

        // Asignamos los botones de la UI
        val btnElfos = findViewById<Button>(R.id.btnElfos)
        val btnEnanos = findViewById<Button>(R.id.btnEnanos)
        val btnHobbits = findViewById<Button>(R.id.btnHobbits)
        val btnHombres = findViewById<Button>(R.id.btnHombres)
        val btnAtras = findViewById<ImageButton>(R.id.btnAtrasCenso)

        // Añadimos los listeners para ver los Listados de cada raza
        btnElfos.setOnClickListener {
            val intent = Intent(this, ListarRaza::class.java).apply {
                putExtra("RAZA", "Elfo")
            }
            startActivity(intent)
        }

        btnEnanos.setOnClickListener {
            val intent = Intent(this, ListarRaza::class.java).apply {
                putExtra("RAZA", "Enano")
            }
            startActivity(intent)
        }

        btnHobbits.setOnClickListener {
            val intent = Intent(this, ListarRaza::class.java).apply {
                putExtra("RAZA", "Hobbit")
            }
            startActivity(intent)
        }

        btnHombres.setOnClickListener {
            val intent = Intent(this, ListarRaza::class.java).apply {
                putExtra("RAZA", "Hombre")
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