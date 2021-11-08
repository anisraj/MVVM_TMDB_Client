package com.example.mvvmtmdbclient.data.repositories.tvshow.datasourceImpl

import com.example.mvvmtmdbclient.data.local.TvShowDao
import com.example.mvvmtmdbclient.data.model.tvshow.TvShow
import com.example.mvvmtmdbclient.data.repositories.tvshow.datasource.TvShowLocaldataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocaldataSource {

    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getAllTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}