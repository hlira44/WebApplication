package com.example.webapplication.api
import retrofit2.Call
import retrofit2.http.*

interface EndPoints {
    //retorna um array de utilizadores
    @GET("/users/")
    fun getUsers(): Call<List<User>>

    //retorna apenas um utilizador por ID
    @GET("/users/{id}")
    fun getUserById(@Path("id") id:Int): Call<User>
}