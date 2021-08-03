package com.example.agenda3telas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ContatosAdapter(var dataSet: MutableList<Pessoal>):RecyclerView.Adapter<ContatosAdapter.ContatosViewHolder>() {
    /************* class ContatosViewHolder *************/
    class ContatosViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val nome = view.findViewById<TextView>(R.id.tvItemNome)
        val celular = view.findViewById<TextView>(R.id.tvItemCelular)
        val descricao = view.findViewById<TextView>(R.id.tvItemDescricao)
    }
    /*********** fim class ContatosViewHolder ***********/

    //infla e envia para o ContatosViewHolder que inicializa como classe normal. Igual na Main.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatosViewHolder { //viewGroup = fragment, activities
        //inflar sem setContentView(R.layout.item_contato)
        val instanciaView = LayoutInflater.from(parent.context).inflate(R.layout.item_contato, parent, false)
        return ContatosViewHolder(instanciaView)
    }

    //relacionavel com o onStart para reciclerView
    override fun onBindViewHolder(holder: ContatosViewHolder, position: Int) {
        holder.nome.text = dataSet[position].getNome()
        holder.celular.text = dataSet[position].getCelular()
        holder.descricao.text = dataSet[position].getReferencia()
    }


    override fun getItemCount(): Int = dataSet.size
}