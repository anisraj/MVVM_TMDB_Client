package com.example.mvvmtmdbclient.domain.repositories

import com.example.mvvmtmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies() : List<Movie>?
    suspend fun updateMovies() : List<Movie>?
}