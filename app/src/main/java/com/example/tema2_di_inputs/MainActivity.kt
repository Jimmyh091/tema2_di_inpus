package com.example.tema2_di_inputs

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var boton = findViewById<Button>(R.id.button)
        boton.setOnClickListener {
            val nombreCorrecto = validarNombre()
            val edadCorrecta = validarEdad()

            if (nombreCorrecto && edadCorrecta) true // mostrar mainActivity
        }
    }

    fun validarNombre() : Boolean{

        var tietNombre = findViewById<TextInputEditText>(R.id.tiet1)

        val texto = tietNombre.text
        var esCorrecto = true

        if (texto != null) {

            if (texto.isEmpty()){
                tietNombre.setError("TUS MUERTOS GILIPOLLAS QUE COJONES HACES")
            }else if(texto.length < 3){
                tietNombre.setError("El nombre no puede tener menos de 3 caracteres")
            }else{
                tietNombre.setError(null)
            }

        }

        return esCorrecto
    }

    fun validarEdad() : Boolean{

        var tietEdad = findViewById<TextInputEditText>(R.id.tiet2)
        val edad = tietEdad.text

        var esCorrecto = true

        if (edad != null && edad.isNotEmpty()) {
            if (edad.toString().toInt() < 18){
                tietEdad.setError("Debes ser mayor de edad")
                esCorrecto = false
            }else{
                tietEdad.setError(null)
            }
        }else{
            esCorrecto
        }

        return esCorrecto
    }
}