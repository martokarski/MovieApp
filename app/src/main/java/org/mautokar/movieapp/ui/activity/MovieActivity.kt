package org.mautokar.movieapp.ui.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.mautokar.movieapp.R
import org.mautokar.movieapp.databinding.ActivityMovieBinding
import org.mautokar.movieapp.model.Movie
import org.mautokar.movieapp.util.MOVIE_PARCELABLE


class MovieActivity : AppCompatActivity() {

    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movie = intent.getParcelableExtra<Movie>(MOVIE_PARCELABLE)
        val binding = DataBindingUtil.setContentView<ActivityMovieBinding>(this, R.layout.activity_movie)
        binding.movie = movie
    }
}
