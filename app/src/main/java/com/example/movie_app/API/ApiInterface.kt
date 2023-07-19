package com.example.movie_app.API

import com.example.movie_app.Model.UpcomingMovieModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("upcoming")
    fun getUpcomingMovies(
        @Query("page") page: Int
    ) :Call<UpcomingMovieModel>

    @GET("popular")
    fun getPopularMovies(
        @Query("page") page: Int
    ) :Call<UpcomingMovieModel>

    @GET("now playing")
    fun getNowplayingMovies(
        @Query("page") page: Int
    ) :Call<UpcomingMovieModel>

    @GET("top rated")
    fun getTopratedMovies(
        @Query("page") page: Int
    ) :Call<UpcomingMovieModel>
}