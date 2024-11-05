package com.example.webapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.webapplication.R
import com.example.webapplication.api.User

class UserAdapter(private val userList: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome: TextView = itemView.findViewById(R.id.Nome)
        val email: TextView = itemView.findViewById(R.id.email)
        val empresa: TextView = itemView.findViewById(R.id.Empresa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerline, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.nome.text = user.name // Ajuste conforme os dados
        holder.email.text = user.email // Ajuste conforme os dados
        holder.empresa.text = user.company.toString() // Ajuste conforme os dados
    }

    override fun getItemCount(): Int = userList.size
}
