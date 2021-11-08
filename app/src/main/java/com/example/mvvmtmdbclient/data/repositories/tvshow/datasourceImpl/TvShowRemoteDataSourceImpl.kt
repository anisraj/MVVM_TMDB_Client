package com.example.mvvmtmdbclient.data.repositories.tvshow.datasourceImpl

import com.example.mvvmtmdbclient.data.model.tvshow.TvShowResponse
import com.example.mvvmtmdbclient.data.remote.api.TMDBServide
import com.example.mvvmtmdbclient.data.repositories.tvshow.datasource.TvShowsRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbServide: TMDBServide,
                                 private val api_key: String
                                 ) : TvShowsRemoteDataSource {

    override suspend fun getPopularTvShows(): Response<TvShowResponse> {
        return tmdbServide.getPopularTvShows(api_key)
    }
}