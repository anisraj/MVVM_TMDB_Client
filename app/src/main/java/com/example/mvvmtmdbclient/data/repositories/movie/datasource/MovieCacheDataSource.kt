package com.example.mvvmtmdbclient.data.repositories.movie.datasource

import com.example.mvvmtmdbclient.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache() : List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}