package org.mautokar.movieapp.ui.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import org.mautokar.movieapp.databinding.MovieTileBinding
import org.mautokar.movieapp.model.Movie
import org.mautokar.movieapp.ui.activity.MovieActivity
import org.mautokar.movieapp.util.MOVIE_PARCELABLE

class MovieAdapter(val dataset : List<Movie>) : RecyclerView.Adapter<MovieHolder>() {

    override fun onBindViewHolder(holder: MovieHolder?, position: Int) {
        holder?.bind(dataset[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MovieHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val movieBinding = MovieTileBinding.inflate(layoutInflater, parent, false)
        return MovieHolder(movieBinding)
    }

    override fun getItemCount() = dataset.size
}


class MovieHolder(val binding: MovieTileBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.movie = movie
        binding.tile.setOnClickListener {
            val intent = Intent(it.context, MovieActivity::class.java)
                    .putExtra(MOVIE_PARCELABLE, binding.movie)
            it.context.startActivity(intent)
        }
    }
}
