package com.example.elevadorsimplificado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.StateSet.TAG

class MainActivity : AppCompatActivity() {
    private lateinit var andar: TextView
    private lateinit var quantidade: TextView
    private lateinit var receberAndar: EditText
    private lateinit var irParaAndar: Button
    private lateinit var entrar: Button
    private lateinit var sair: Button
    private lateinit var label: TextView
    private lateinit var inferior: androidx.constraintlayout.widget.ConstraintLayout
    private val capacidade = 6
    private var qtdPessoas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        andar = findViewById(R.id.textAndar)
        quantidade = findViewById(R.id.textQuantidade)
        irParaAndar = findViewById(R.id.buttonIrParaAndar)
        receberAndar = findViewById(R.id.editTextAndar)
        irParaAndar = findViewById(R.id.buttonIrParaAndar)
        entrar = findViewById(R.id.buttonEntrar)
        sair = findViewById(R.id.buttonSair)
        label = findViewById(R.id.textViewLabelFim)
        inferior = findViewById(R.id.constraintLayoutFim)
        sair.text = "VAZIO"
        //sair.setBackgroundColor(R.color.corSair)

        irParaAndar.setOnClickListener() {
            var andarInformado = receberAndar.text.toString()
            if (andarInformado.isNotEmpty()) { //tratar andares maiores
                andar.text = andarInformado.toString()
                receberAndar.text = null
                inferior.visibility = View.VISIBLE
            } else receberAndar.error = "Informe um andar."
        }

        entrar.setOnClickListener(){
            if (qtdPessoas < capacidade) {
                qtdPessoas = qtdPessoas + 1
                quantidade.text = qtdPessoas.toString() + "/${capacidade.toString()}"
                inferior.visibility = View.INVISIBLE
                if (qtdPessoas == capacidade) {
                    entrar.text = "LOTADO"
                }
                if (qtdPessoas == 1){
                    sair.text = "SAIR"
                }
            }
        }

        sair.setOnClickListener(){
            if (qtdPessoas > 0) {
                if (qtdPessoas == capacidade) {
                    entrar.text = "ENTRAR"
                }
                qtdPessoas = qtdPessoas - 1
                quantidade.text = qtdPessoas.toString() + "/${capacidade.toString()}"
                inferior.visibility = View.INVISIBLE
                if (qtdPessoas == 0) {
                    sair.text = "VAZIO"
                }
            }
        }
    }
}