package com.example.tema2_di_inputs

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class ej2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var boton = findViewById<Button>(R.id.ej2_button)
        boton.setOnClickListener {
            validarNombre()
            validarEmail()
            validarContrasenia()
        }
    }

    fun validarNombre() : Boolean{
        var tietNombre = findViewById<TextInputEditText>(R.id.ej2_tiet1)
        val nombre = tietNombre.text

        var esCorrecto = true

        if (nombre != null){
            if (nombre.isEmpty()){
                tietNombre.setError("El nombre es obligatorio")
                esCorrecto = false
            }else{
                tietNombre.setError(null)
            }
        }

        return esCorrecto
    }

    fun validarEmail() : Boolean{
        var tietNombre = findViewById<TextInputEditText>(R.id.ej2_tiet2)
        val email = tietNombre.text

        var esCorrecto = true

        if (email != null){
            if (!email.contains("@") || !email.contains(".")){
                tietNombre.setError("El email esta mal")
                esCorrecto = false
            }else{
                tietNombre.setError(null)
            }
        }

        return esCorrecto
    }

    fun validarContrasenia() : Boolean{
        var tietNombre = findViewById<TextInputEditText>(R.id.ej2_tiet3)
        val contrasenia = tietNombre.text

        var esCorrecto = true

        if (contrasenia != null){
            if (contrasenia.length < 6){
                tietNombre.setError("La contrasenia tiene que tener al menos 6 caracteres")
                esCorrecto = false
            }else{
                tietNombre.setError(null)
            }
        }

        return esCorrecto
    }
}