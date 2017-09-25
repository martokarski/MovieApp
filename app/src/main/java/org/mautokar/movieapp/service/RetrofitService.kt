package org.mautokar.movieapp.service

import org.mautokar.movieapp.model.MoviePage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("movie/popular")
    fun getPopular(@Query("api_key") apiKey: String): Call<MoviePage>
}