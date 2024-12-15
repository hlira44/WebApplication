package com.example.webapplication.api

// Estrutura dos dados
data class Escola(
    val id: Int,
    val name: String,
    val curso: List<Curso>

)

data class Curso(
    val id: Int,
    val name: String,
    val estagios: List<Estagio>
)

data class Estagio(
    val id: Int,
    val name: String,
    val local: String,
    val descricao: String
)


