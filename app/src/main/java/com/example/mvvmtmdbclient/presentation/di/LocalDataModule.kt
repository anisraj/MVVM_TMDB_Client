package com.example.mvvmtmdbclient.presentation.di

import com.example.mvvmtmdbclient.data.local.ArtistsDao
import com.example.mvvmtmdbclient.data.local.MovieDao
import com.example.mvvmtmdbclient.data.local.TvShowDao
import com.example.mvvmtmdbclient.data.repositories.artist.datasource.ArtistLocalDataSource
import com.example.mvvmtmdbclient.data.repositories.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.example.mvvmtmdbclient.data.repositories.movie.datasource.MovieLocalDataSource
import com.example.mvvmtmdbclient.data.repositories.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.mvvmtmdbclient.data.repositories.tvshow.datasource.TvShowLocaldataSource
import com.example.mvvmtmdbclient.data.repositories.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providesMovieLocalDataSource(movieDao: MovieDao) : MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun providesTvShowsLocalDataSource(tvShowDao: TvShowDao) : TvShowLocaldataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun providesArtistsLocalDataSource(artistsDao: ArtistsDao) : ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistsDao)
    }
}