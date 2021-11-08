package com.example.mvvmtmdbclient.data.repositories.movie.datasource

import com.example.mvvmtmdbclient.data.model.movie.MovieResponse
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getPopularMovies() : Response<MovieResponse>
}