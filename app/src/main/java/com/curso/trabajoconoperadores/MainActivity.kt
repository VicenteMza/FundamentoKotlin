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
            mostrarMensaje(numero, miResultado)
        }

        miBotonSumar.setOnClickListener {
            val numeroInicial: Int? = miNumero.text.toString().toIntOrNull()
            if (numeroInicial == null) {
                miResultado.text = "No es un número"
            } else {
                val numeroIncremento = numeroInicial + 1
                miNumero.setText(numeroIncremento.toString())
                mostrarMensaje(numeroIncremento, miResultado)
            }
        }
        miBotonRestar.setOnClickListener {
            val numeroInicial: Int? = miNumero.text.toString().toIntOrNull()
            if (numeroInicial == null) {
                miResultado.text = "No es un número"
            } else {
                val numeroIncremento = numeroInicial - 1
                miNumero.setText(numeroIncremento.toString())
                mostrarMensaje(numeroIncremento,miResultado)
            }
        }
    }

    private fun mostrarMensaje(edad: Int?, txtResult: TextView) {
        val mensaje = when (edad) {
            null -> "No es un numero"
            in 0..17 -> "Es menor de edad"
            in 18..30 -> "Es un adulto joven"
            in 31..110 -> "Es un adulto mayor"
            else -> "tienes $edad años"
        }
        txtResult.text = mensaje
    }
}