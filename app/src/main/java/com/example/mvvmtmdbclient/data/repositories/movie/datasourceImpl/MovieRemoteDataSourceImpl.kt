package com.example.mvvmtmdbclient.data.repositories.movie.datasourceImpl

import com.example.mvvmtmdbclient.data.model.movie.MovieResponse
import com.example.mvvmtmdbclient.data.remote.api.TMDBServide
import com.example.mvvmtmdbclient.data.repositories.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbServide: TMDBServide,
                                private val api_key: String)
    : MovieRemoteDataSource {

    override suspend fun getPopularMovies(): Response<MovieResponse> {
        return tmdbServide.getPopularMovies(api_key)
    }
}