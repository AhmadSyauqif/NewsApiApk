package com.example.newsapiapk.service

import com.example.newsapiapk.model.ResponseNews
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers


object RetrofitBuilder {
    private val client = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getService() = retrofit.create(TopHeadlines::class.java)
}

interface TopHeadlines{
    @Headers("Authorization = ce315bb914ab44d7866da6788eeed502")
    @GET ("/v2/top-headlines?country=id")
    fun fetchHeadlines(): Call<ResponseNews>
}
