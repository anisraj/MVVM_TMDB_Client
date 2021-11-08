package com.example.mvvmtmdbclient.data.repositories.tvshow.datasource

import com.example.mvvmtmdbclient.data.model.tvshow.TvShow

interface TvShowLocaldataSource {
    suspend fun getTvShowsFromDB() : List<TvShow>
    suspend fun saveTvShowsToDB(tvShows : List<TvShow>)
    suspend fun clearAll()
}