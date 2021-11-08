package com.example.mvvmtmdbclient.domain.repositories

import com.example.mvvmtmdbclient.data.model.tvshow.TvShow


interface TvShowsRepository {
    suspend fun getTvshows() : List<TvShow>?
    suspend fun updateTvShows() : List<TvShow>?
}