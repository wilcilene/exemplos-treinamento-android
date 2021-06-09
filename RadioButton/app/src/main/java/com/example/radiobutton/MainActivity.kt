package com.example.radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var radioGroupMain: RadioGroup
    private lateinit var radio1: RadioButton
    private lateinit var radio2: RadioButton
    private lateinit var radio3: RadioButton

    private lateinit var mensagem: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        radioGroupMain = findViewById(R.id.radioGroup)
        radio1 = findViewById(R.id.radioButton1)
        radio2 = findViewById(R.id.radioButton2)
        radio3 = findViewById(R.id.radioButton3)

        mensagem = findViewById(R.id.textViewMensagem)


        radioGroupMain.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radioButton1)
                mensagem.text = radio1.text.toString()
            if (checkedId == R.id.radioButton2)
                mensagem.text = radio2.text.toString()
            if (checkedId == R.id.radioButton3)
                mensagem.text = radio3.text.toString()
        }
    }
}