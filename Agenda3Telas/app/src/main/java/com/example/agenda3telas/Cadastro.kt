package com.example.agenda3telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class Cadastro : AppCompatActivity() {
    private lateinit var btnHome: ImageButton
    private lateinit var nome: EditText
    private lateinit var celular: EditText
    private lateinit var rgOpcoes: RadioGroup
    private lateinit var rbPessoal: RadioButton
    private lateinit var rbProfissional: RadioButton
    private lateinit var referencia: EditText
    private lateinit var email: EditText
    private lateinit var btnSalvar: Button
    private lateinit var tipoContato: String
    //var contatosPessoaisCadastrados = mutableListOf<Pessoal>()
    //var contatosProfissionaisCadastrados = mutableListOf<Profissional>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        bindView()
    }

    private fun bindView() {
        btnHome = findViewById(R.id.imageButtonHome)
        nome = findViewById(R.id.editTextNome)
        celular = findViewById(R.id.editTextCelular)
        rgOpcoes = findViewById(R.id.radioGroupOpcoes)
        rbPessoal = findViewById(R.id.radioButtonPessoal)
        rbProfissional = findViewById(R.id.radioButtonProfissional)
        referencia = findViewById(R.id.editTextReferencia)
        email = findViewById(R.id.editTextEmail)
        btnSalvar = findViewById(R.id.buttonSalvar)

        btnHome.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            //intent.putExtra("ContatosPessoais", contatosPessoaisCadastrados)
            startActivity(intent)
        }

        rgOpcoes.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radioButtonPessoal) {
                tipoContato = "Pessoal"
                email.visibility = View.INVISIBLE
                referencia.visibility = View.VISIBLE
            }
            if (checkedId == R.id.radioButtonProfissional) {
                tipoContato = "Profissional"
                referencia.visibility = View.INVISIBLE
                email.visibility = View.VISIBLE
            }
        }

        btnSalvar.setOnClickListener {
            val nomeInformado = nome.text.toString()
            val celularInformado = celular.text.toString()
            if (tipoContato == "Pessoal") {
                val referenciaInformada = referencia.text.toString()
                adicionarNaLista(nomeInformado, celularInformado, referenciaInformada)
            } else {
                val emailInformado = email.text.toString()
                adicionarNaLista(nomeInformado, celularInformado, emailInformado)
            }
            nome.text = null
            celular.text = null
            referencia.text = null
            email.text = null
        }
    }

    companion object{
        var contatosPessoaisCadastrados = mutableListOf<Pessoal>()
        var contatosProfissionaisCadastrados = mutableListOf<Profissional>()
    }

    override fun onStart() {
        super.onStart()
        Log.d("Meu Aplicativo","No onStart Cadastro.")
    }

    fun adicionarNaLista(
        nomeInformado: String,
        celularInformado: String,
        referenciaOuEmail: String
    ) {
        if (tipoContato == "Pessoal") {
            var contatoPessoal = Pessoal(nomeInformado, celularInformado, referenciaOuEmail)
            contatosPessoaisCadastrados.add(contatoPessoal)
        } else {
            var contatoProfissional = Profissional(nomeInformado, celularInformado, referenciaOuEmail)
            contatosProfissionaisCadastrados.add(contatoProfissional)
        }
    }
}


