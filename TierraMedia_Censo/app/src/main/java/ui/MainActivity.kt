package ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import bbdd.HabitantesSQLite
import com.elsda.tierramedia_pac.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_TierraMedia_Pac)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Buscamos el botón censo
        val btnCenso = findViewById<Button>(R.id.btnCenso)

//Comprobando que funciona la función del Crud(Read)

        /**
        val habitantesSQLite= HabitantesSQLite(this)

        val numHabitantesxraza=habitantesSQLite.getNumeroHabitantesPorRaza("Enano")
        Log.d("MainActivity", "numero de habitantes de la raza enano:$numHabitantesxraza")
        */

        // Establece el OnClickListener para el botón Censo
        btnCenso.setOnClickListener {
            // Crea un Intent para iniciar EligeOpcion
            val intent = Intent(this, EligeOpcion::class.java)
            startActivity(intent)
        }

        val swDarkMode= findViewById<SwitchCompat>(R.id.swDarkMode)

        swDarkMode.setOnCheckedChangeListener { _, isSelected ->
            if (isSelected){
                enableDarkMode()
            }else{
                disableDarkMode()
            }
        }

    }

    private fun enableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        delegate.applyDayNight()
    }

    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        delegate.applyDayNight()
    }
}