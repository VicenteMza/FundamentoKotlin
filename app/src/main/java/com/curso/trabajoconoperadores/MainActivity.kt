package com.curso.trabajoconoperadores

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.curso.trabajoconoperadores.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val miNumero:EditText = findViewById(R.id.resultadoEdad)
        val miBoton: Button = findViewById(R.id.button)
        val miResultado: TextView = findViewById(R.id.mensajes)

        val miBotonSumar: Button = findViewById(R.id.botonSumar)
        val miBotonRestar: Button = findViewById(R.id.botonRestar)

        miBoton.setOnClickListener{
            val numero: Int? = miNumero.text.toString().toIntOrNull()
            miResultado.text= if (numero == null) "No es un numero"
            else if (numero < 18) "Es menor de edad"
            else if(numero > 18) "Es mayor de edad"
            else "tienes $numero años"
        }

        miBotonSumar.setOnClickListener {
            val numeroInicial: Int? = miNumero.text.toString().toIntOrNull()
            if (numeroInicial == null) {
                miResultado.text = "No es un número"
            } else {
                val numeroIncremento = numeroInicial + 1
                miNumero.setText(numeroIncremento.toString())
            }
        }
        miBotonRestar.setOnClickListener {
            val numeroInicial: Int? = miNumero.text.toString().toIntOrNull()
            if (numeroInicial == null) {
                miResultado.text = "No es un número"
            } else {
                val numeroIncremento = numeroInicial - 1
                miNumero.setText(numeroIncremento.toString())
            }
        }
    }
}