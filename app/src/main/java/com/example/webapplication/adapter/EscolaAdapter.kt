package com.example.webapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.webapplication.R
import com.example.webapplication.api.Escola

class EscolaAdapter(private val escolaList: List<Escola>) : RecyclerView.Adapter<EscolaAdapter.EscolaViewHolder>() {

    inner class EscolaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.nomeEscola)
        val curso: TextView = itemView.findViewById(R.id.curso)
        val estagios: TextView = itemView.findViewById(R.id.estagio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EscolaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerline, parent, false)
        return EscolaViewHolder(view)
    }

    override fun onBindViewHolder(holder: EscolaViewHolder, position: Int) {
        val escola = escolaList[position]
        holder.name.text = escola.name // Nome da escola

        // Verificar se há cursos disponíveis
        if (escola.curso.isNotEmpty()) {
            val curso = escola.curso[0] // Pega o primeiro curso
            holder.curso.text = curso.name // Nome do curso

            // Verificar se há estágios disponíveis
            if (curso.estagios.isNotEmpty()) {
                val estagio = curso.estagios[0] // Pega o primeiro estágio
                holder.estagios.text = "Local: ${estagio.local}, Desc: ${estagio.descricao}" // Exibir informações do estágio
            } else {
                holder.estagios.text = "Nenhum estágio disponível"
            }
        } else {
            holder.curso.text = "Nenhum curso disponível"
            holder.estagios.text = "" // Limpa o campo dos estágios
        }
    }

    override fun getItemCount(): Int = escolaList.size
}
