package com.example.mvvmtmdbclient.data.repositories.movie

import android.util.Log
import com.example.mvvmtmdbclient.data.model.movie.Movie
import com.example.mvvmtmdbclient.data.repositories.movie.datasource.MovieCacheDataSource
import com.example.mvvmtmdbclient.data.repositories.movie.datasource.MovieLocalDataSource
import com.example.mvvmtmdbclient.data.repositories.movie.datasource.MovieRemoteDataSource
import com.example.mvvmtmdbclient.domain.repositories.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListMovies)
        movieCacheDataSource.saveMoviesToCache(newListMovies)
        return newListMovies
    }

    suspend fun getMoviesFromApi() : List<Movie> {
        lateinit var movieList : List<Movie>
        try {
            val response = movieRemoteDataSource.getPopularMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (exception : Exception) {
            Log.i("MyTAG", exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB() : List<Movie> {
        lateinit var movieList : List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (exception : Exception) {
            Log.i("MyTAG", exception.message.toString())
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache() : List<Movie> {
        lateinit var movieList : List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (exception : Exception) {
            Log.i("MyTAG", exception.message.toString())
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}