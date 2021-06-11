package com.example.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var nome: EditText
    private lateinit var celular: EditText
    private lateinit var pessoal: RadioButton
    private lateinit var profissional: RadioButton
    private lateinit var referencia: EditText
    private lateinit var email: EditText
    private lateinit var salvar: Button
    private lateinit var pesquisar: EditText
    private lateinit var btnPesquisar: ImageButton
    private lateinit var contatos: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //bindViews()
    }
    //val textView: TextView? = findViewById(R.id.editTextNome)

}