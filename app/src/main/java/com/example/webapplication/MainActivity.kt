package com.example.webapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.webapplication.adapter.EscolaAdapter
import com.example.webapplication.adapter.RecyclerAdapter
import com.example.webapplication.api.EndPoints
import com.example.webapplication.api.Escola
import com.example.webapplication.api.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val request = ServiceBuilder.buildService(EndPoints::class.java)
        val call = request.getEscolas()

        call.enqueue(object : Callback<List<Escola>> {
            override fun onResponse(call: Call<List<Escola>>, response: Response<List<Escola>>) {
                if (response.isSuccessful) {
                    val recycler = findViewById<RecyclerView>(R.id.recyclerline)
                    recycler.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = EscolaAdapter(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<List<Escola>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                Log.d("DEBUG", t.message.toString())
            }
        })
    }
}











/*
    fun getSingle (view: View){
        val requestid = ServiceBuilder.buildService(EndPoints::class.java)
        val callid = requestid.getUserById(10)

        callid.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val c: User = response.body()!!
                    Toast.makeText(this@MainActivity, c.address.zipcode, Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

    }



    fun post(view: View){
        val requestpost = ServiceBuilder.buildService(EndPoints::class.java)
        val callpost = requestpost.postTest("teste")
        callpost.enqueue(object : Callback<OutputPost>{
            override fun onResponse(callpost: Call<OutputPost>, response: Response<OutputPost>) {
                if (response.isSuccessful){
                    val c: OutputPost = response.body()!!
                    Toast.makeText(this@MainActivity, c.id.toString() + "-" + c.title, Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<OutputPost>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })


    }
*/







