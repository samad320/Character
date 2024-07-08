package com.example.apirecyclerview.Retrofit



import com.example.apirecyclerview.model.ModelChar
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @GET("character")
    fun character(
    ): Call<ModelChar>

}