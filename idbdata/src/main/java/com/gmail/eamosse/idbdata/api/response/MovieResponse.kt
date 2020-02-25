package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.Movie
import com.google.gson.annotations.SerializedName

internal data class MovieResponse(
    @SerializedName("genres")
    val genres: List<Movie>
) {
    data class Genre(
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String
    )
}

internal fun MovieResponse.Genre.toListFilm() = Movie(id = id, title = title)