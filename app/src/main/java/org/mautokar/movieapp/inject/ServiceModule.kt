package org.mautokar.movieapp.inject

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import org.mautokar.movieapp.App
import org.mautokar.movieapp.service.MovieService
import org.mautokar.movieapp.service.RetrofitService
import org.mautokar.movieapp.util.MOVIE_DB_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideService(app: App, retrofitService: RetrofitService) = MovieService(app, retrofitService)

    @Provides
    @Singleton
    fun provideRetrofit(): RetrofitService = Retrofit.Builder().run {
        baseUrl(MOVIE_DB_BASE_URL)
        addConverterFactory(GsonConverterFactory
                .create(GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                        .create()))
        build().create(RetrofitService::class.java)
    }
}
