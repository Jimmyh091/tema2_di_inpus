package com.example.tema2_di_inputs

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        validar()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun validar() : Boolean{
        val textInputLayout = findViewById<TextInputLayout>(R.id.ti1)
        print(textInputLayout)

        return false
    }

    fun validarNombre(texto: String) : Boolean{
        var esCorrecto = true

        esCorrecto = texto.isNotEmpty()
        if (esCorrecto) esCorrecto = texto.length < 2

        return esCorrecto
    }

    fun validarEdad(edad: Int) : Boolean{
        return edad < 18
    }
}