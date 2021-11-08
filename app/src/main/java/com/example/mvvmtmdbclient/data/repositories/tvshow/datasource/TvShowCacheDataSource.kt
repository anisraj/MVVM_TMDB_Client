package com.example.mvvmtmdbclient.data.repositories.tvshow.datasource

import com.example.mvvmtmdbclient.data.model.tvshow.TvShow


interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache() : List<TvShow>
    suspend fun saveTvShowsToCache(movies: List<TvShow>)
}