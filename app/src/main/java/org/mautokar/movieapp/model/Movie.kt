package org.mautokar.movieapp.model

import android.os.Parcel
import android.os.Parcelable
import org.mautokar.movieapp.util.booleanValue

data class Movie(val id: Int,
                 val posterPath: String,
                 val adult: Boolean,
                 val overview: String,
                 val releaseDate: String,
                 val originalTitle: String,
                 val originalLanguage: String,
                 val title: String) : Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Movie> = object : Parcelable.Creator<Movie> {
            override fun createFromParcel(source: Parcel): Movie = Movie(source)
            override fun newArray(size: Int): Array<Movie?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readInt(),
            source.readString(),
            source.readByte().booleanValue,
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(posterPath)
        dest.writeByte(if (adult) 1 else 0)
        dest.writeString(overview)
        dest.writeString(releaseDate)
        dest.writeString(originalTitle)
        dest.writeString(originalLanguage)
        dest.writeString(title)
    }
}
