package com.example.agenda3telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnCadastro: Button
    private lateinit var btnConsulta: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
    }

    private fun bindViews(){
        btnCadastro = findViewById(R.id.buttonIrCadastro)
        btnConsulta = findViewById(R.id.buttonIrConsulta)

        btnCadastro.setOnClickListener{
            val intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }

        btnConsulta.setOnClickListener{
            val intent = Intent(this, Consulta::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Meu Aplicativo","No onStart Main.")
    }


}