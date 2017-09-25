package org.mautokar.movieapp.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun setImageUrl(image: ImageView, path: String) {
    Picasso
            .with(image.context)
            .load(MOVIE_DB_IMAGE_URL + path)
            .fit()
            .into(image)
}
