package com.example.mvvmtmdbclient.data.model.movie

import com.example.mvvmtmdbclient.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val movies: List<Movie>
)
