package com.example.mvvmtmdbclient.data.remote.api

import com.example.mvvmtmdbclient.data.model.artist.ArtistResponse
import com.example.mvvmtmdbclient.data.model.movie.MovieResponse
import com.example.mvvmtmdbclient.data.model.tvshow.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBServide {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String)
    : Response<MovieResponse>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey: String)
            : Response<TvShowResponse>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey: String)
            : Response<ArtistResponse>
}