package com.example.mvvmtmdbclient.data.repositories.tvshow.datasourceImpl

import com.example.mvvmtmdbclient.data.model.tvshow.TvShow
import com.example.mvvmtmdbclient.data.repositories.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShows = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShows
    }

    override suspend fun saveTvShowsToCache(tvShow: List<TvShow>) {
        tvShows.clear()
        tvShows = ArrayList(tvShow)
    }
}