package com.example.agenda3telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Consulta : AppCompatActivity() {
    private lateinit var btnHome: FloatingActionButton
    private lateinit var pesquisar: EditText
    private lateinit var btnPesquisar: ImageButton
    private lateinit var contatos: TextView
    private lateinit var btnContatos: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)
        bindView()
    }

    override fun onStart() {
        super.onStart()
        Log.d("Meu Aplicativo","No onStart Consulta.")
    }

    private fun bindView(){
        btnHome = findViewById(R.id.floatingActionButtonHome)
        pesquisar = findViewById(R.id.editTextPesquisar)
        btnPesquisar = findViewById(R.id.imageButtonPesquisar)
        contatos = findViewById(R.id.textViewContatos)
        btnContatos = findViewById(R.id.buttonContatos)

        btnHome.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnPesquisar.setOnClickListener{
            val nomePesquisado = pesquisar.text.toString()
            pesquisarContato(nomePesquisado)
        }

        btnContatos.setOnClickListener{
            exibirListaOrdenada()
        }

    }

    fun exibirListaOrdenada(){
        Cadastro.contatosPessoaisCadastrados.sortBy { it.getNome() }
        var concatenaResultado = ""
        if (Cadastro.contatosPessoaisCadastrados.size > 0) {
            concatenaResultado = "CONTATOS PESSOAIS:\nNome\t-\tCelular\t-\tReferência\n"
            for (contato in Cadastro.contatosPessoaisCadastrados) {
                concatenaResultado += contato.getNome() + "\t-\t" + contato.getCelular() + "\t-\t" + contato.getReferencia() + "\n"
            }
        }

        if (Cadastro.contatosProfissionaisCadastrados.size > 0) {
            Cadastro.contatosProfissionaisCadastrados.sortBy { it.getNome() }
            concatenaResultado += "CONTATOS PROFISSIONAIS:\nNome\t-\tCelular\t-\tEmail\n"
            for (contato in Cadastro.contatosProfissionaisCadastrados) {
                concatenaResultado += contato.getNome() + " - " + contato.getCelular() + " - " + contato.getEmail() + "\n"
            }
        }
        contatos.text = concatenaResultado
    }

    fun pesquisarContato(nomeInformado: String){
        var saida = "Não encontrado, cadastre e pesquise novamente."
        for (contato in Cadastro.contatosPessoaisCadastrados) {
            if (contato.getNome().toUpperCase() == nomeInformado.toUpperCase()) {
                saida =
                    "Nome: " + contato.getNome() + "\tCelular: " + contato.getCelular() + "\nReferência: " + contato.getReferencia()
            }
        }
        for (contato in Cadastro.contatosProfissionaisCadastrados) {
            if (contato.getNome().toUpperCase() == nomeInformado.toUpperCase()) {
                saida = "Nome: " + contato.getNome() + "\tCelular: " + contato.getCelular() + "\nEmail: " + contato.getEmail()
            }
        }
        contatos.text = saida
    }
}