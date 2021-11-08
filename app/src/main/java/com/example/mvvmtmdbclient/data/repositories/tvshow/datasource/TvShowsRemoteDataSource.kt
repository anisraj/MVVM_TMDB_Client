package com.example.mvvmtmdbclient.data.repositories.tvshow.datasource

import com.example.mvvmtmdbclient.data.model.tvshow.TvShowResponse
import retrofit2.Response

interface TvShowsRemoteDataSource {
    suspend fun getPopularTvShows() : Response<TvShowResponse>
}