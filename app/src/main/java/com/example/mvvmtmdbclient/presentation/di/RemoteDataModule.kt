package com.example.mvvmtmdbclient.presentation.di

import com.example.mvvmtmdbclient.data.remote.api.TMDBServide
import com.example.mvvmtmdbclient.data.repositories.artist.datasource.ArtistRemoteDataSource
import com.example.mvvmtmdbclient.data.repositories.artist.datasourceImpl.ArtistsRemoteSourceImpl
import com.example.mvvmtmdbclient.data.repositories.movie.datasource.MovieRemoteDataSource
import com.example.mvvmtmdbclient.data.repositories.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.mvvmtmdbclient.data.repositories.tvshow.datasource.TvShowsRemoteDataSource
import com.example.mvvmtmdbclient.data.repositories.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun providesMovieRemotedataSource(tmdbServide: TMDBServide) : MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbServide, apiKey)
    }

    @Singleton
    @Provides
    fun providesTvshowsRemotedataSource(tmdbServide: TMDBServide) : TvShowsRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbServide, apiKey)
    }

    @Singleton
    @Provides
    fun providesArtistsRemotedataSource(tmdbServide: TMDBServide) : ArtistRemoteDataSource {
        return ArtistsRemoteSourceImpl(tmdbServide, apiKey)
    }
}