package com.example.mvvmtmdbclient.data.repositories.tvshow

import android.util.Log
import com.example.mvvmtmdbclient.data.model.tvshow.TvShow
import com.example.mvvmtmdbclient.data.repositories.tvshow.datasource.TvShowCacheDataSource
import com.example.mvvmtmdbclient.data.repositories.tvshow.datasource.TvShowLocaldataSource
import com.example.mvvmtmdbclient.data.repositories.tvshow.datasource.TvShowsRemoteDataSource
import com.example.mvvmtmdbclient.domain.repositories.TvShowsRepository

class TvShowRepositoryImpl(
    private val tvShowsRemoteDataSource: TvShowsRemoteDataSource,
    private val tvShowLocaldataSource: TvShowLocaldataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowsRepository {

    override suspend fun getTvshows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListTvShows = getTvShowsFromApi()
        tvShowLocaldataSource.clearAll()
        tvShowLocaldataSource.saveTvShowsToDB(newListTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListTvShows)
        return newListTvShows
    }

    suspend fun getTvShowsFromApi() : List<TvShow> {
        lateinit var tvShowList : List<TvShow>
        try {
            val response = tvShowsRemoteDataSource.getPopularTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (exception : Exception) {
            Log.i("MyTAG", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB() : List<TvShow> {
        lateinit var tvShowList : List<TvShow>
        try {
            tvShowList = tvShowLocaldataSource.getTvShowsFromDB()
        } catch (exception : Exception) {
            Log.i("MyTAG", exception.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromApi()
            tvShowLocaldataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache() : List<TvShow> {
        lateinit var tvShowList : List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        } catch (exception : Exception) {
            Log.i("MyTAG", exception.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }
}