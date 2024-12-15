package com.example.webapplication.api
import retrofit2.Call
import retrofit2.http.*

interface EndPoints {

    // Retorna uma lista de escolas
    @GET("/api/escolas")
    fun getEscolas(): Call<List<Escola>>

    // Retorna uma lista de cursos para uma determinada escola
    @GET("/api/escolas/{id}")
    fun getCursosPorEscola(@Path("id") id: Int): Call<Escola>

    // Retorna um estágio por ID dentro de um curso de uma escola
    @GET("/api/escolas/{escola}/cursos/{curso}/estagios/{id}")
    fun getEstagioPorId(
        @Path("escola") escola: String,
        @Path("curso") curso: String,
        @Path("id") id: Int
    ): Call<Estagio>

    // Cria um novo estágio para um curso em uma escola

}

