package org.mautokar.movieapp.service

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import org.mautokar.movieapp.App
import org.mautokar.movieapp.R
import org.mautokar.movieapp.model.Movie
import java.io.IOException
import javax.inject.Inject

private val TAG = MovieService::class.java.name

class MovieService @Inject constructor(private val app: App, private val service: RetrofitService) {

    private val apiKey = app.getString(R.string.api_key)

    fun retrieveMoviesAsync() = async(CommonPool) {
            var result = emptyList<Movie>()

            if (checkInternetConnection()) {
                try {
                    val response = service.getPopular(apiKey).execute()

                    if (response.isSuccessful) {
                        result = response.body()?.results ?: emptyList()
                    } else {
                        Log.w(TAG, "Response unsuccessful due to: ${response.errorBody()}")
                    }
                } catch (e: IOException) {
                    Log.e(TAG, "Error during connection. $e")
                }
            }

            result
        }

    private fun checkInternetConnection(): Boolean {
        val cm = app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo

        return netInfo != null && netInfo.isConnected
    }
}
