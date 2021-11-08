package com.example.mvvmtmdbclient.presentation.di

import com.example.mvvmtmdbclient.data.repositories.artist.datasource.ArtistCacheDataSource
import com.example.mvvmtmdbclient.data.repositories.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.example.mvvmtmdbclient.data.repositories.movie.datasource.MovieCacheDataSource
import com.example.mvvmtmdbclient.data.repositories.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.example.mvvmtmdbclient.data.repositories.tvshow.datasource.TvShowCacheDataSource
import com.example.mvvmtmdbclient.data.repositories.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun providesMovieCacheDataSource() : MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providesTvShowsCacheDataSource() : TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providesArtistsCacheDataSource() : ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}