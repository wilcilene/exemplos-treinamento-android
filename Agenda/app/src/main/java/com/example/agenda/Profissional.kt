package com.example.agenda

class Profissional(
    nome: String,
    celular: String,
    private var referencia: String
    ) : Contato( nome, celular)
{
    fun getReferencia() : String {
        return referencia
    }
}