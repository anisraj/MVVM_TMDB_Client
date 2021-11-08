package com.example.mvvmtmdbclient.domain.use_cases

import com.example.mvvmtmdbclient.data.model.movie.Movie
import com.example.mvvmtmdbclient.domain.repositories.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}