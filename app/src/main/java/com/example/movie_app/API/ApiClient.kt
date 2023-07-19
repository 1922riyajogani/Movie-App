package com.example.movie_app.API

import android.telecom.Call
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{

        val BASE_URL = "https://api.themoviedb.org/3/movie/"
        val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
        lateinit var retrofit: Retrofit
        val TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwMjdjODY3OGQyNmJlN2EyNWU1NGZjZDc3ODZkNTc2MiIsInN1YiI6IjY0Yjc3ZTMxZjI2M2JhMDEzOWY0MDQzYSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.7Ix56dFgDdVXoIyh09KQQqaPs8Yl8kygboPAaVQ7q9E"

        fun getApiClient(): Retrofit {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().addInterceptor { Chain ->

                    val request = Chain.request().newBuilder().addHeader("Authorization","Bearera${TOKEN}").build()
                    Chain.proceed(request)
                }.build())
                .build()
            return retrofit
        }
    }
}