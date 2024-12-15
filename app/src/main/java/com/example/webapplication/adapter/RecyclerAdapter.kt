package com.example.webapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.webapplication.R
import com.example.webapplication.api.Escola

class RecyclerAdapter(private val itemList: List<Escola>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerline, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.escolaTextView.text = item.name
        holder.cursoTextView.text = item.curso.toString()
        holder.estagioTextView.text = item.curso.indices.first.toString()
    }

    override fun getItemCount(): Int = itemList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val escolaTextView: TextView = itemView.findViewById(R.id.nomeEscola)
        val cursoTextView: TextView = itemView.findViewById(R.id.curso)
        val estagioTextView: TextView = itemView.findViewById(R.id.estagio)
    }
}

