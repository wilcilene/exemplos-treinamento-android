package com.example.agenda3telas

class Profissional(nomePessoal: String,
                   celularPessoal: String,
                   private var email : String
) : Contato(nome = nomePessoal,
    celular = celularPessoal
) {
    fun getEmail(): String {
        return email
    }
}