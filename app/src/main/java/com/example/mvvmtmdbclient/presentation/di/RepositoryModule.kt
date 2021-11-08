package com.example.mvvmtmdbclient.presentation.di

import com.example.mvvmtmdbclient.data.repositories.artist.ArtistRepositoryImpl
import com.example.mvvmtmdbclient.data.repositories.artist.datasource.ArtistCacheDataSource
import com.example.mvvmtmdbclient.data.repositories.artist.datasource.ArtistLocalDataSource
import com.example.mvvmtmdbclient.data.repositories.artist.datasource.ArtistRemoteDataSource
import com.example.mvvmtmdbclient.data.repositories.artist.datasourceImpl.ArtistsRemoteSourceImpl
import com.example.mvvmtmdbclient.data.repositories.movie.MovieRepositoryImpl
import com.example.mvvmtmdbclient.data.repositories.movie.datasource.MovieCacheDataSource
import com.example.mvvmtmdbclient.data.repositories.movie.datasource.MovieLocalDataSource
import com.example.mvvmtmdbclient.data.repositories.movie.datasource.MovieRemoteDataSource
import com.example.mvvmtmdbclient.data.repositories.tvshow.TvShowRepositoryImpl
import com.example.mvvmtmdbclient.data.repositories.tvshow.datasource.TvShowCacheDataSource
import com.example.mvvmtmdbclient.data.repositories.tvshow.datasource.TvShowLocaldataSource
import com.example.mvvmtmdbclient.data.repositories.tvshow.datasource.TvShowsRemoteDataSource
import com.example.mvvmtmdbclient.domain.repositories.ArtistsRepository
import com.example.mvvmtmdbclient.domain.repositories.MovieRepository
import com.example.mvvmtmdbclient.domain.repositories.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ) : MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowsRemoteDataSource: TvShowsRemoteDataSource,
        tvShowLocaldataSource: TvShowLocaldataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ) : TvShowsRepository {
        return TvShowRepositoryImpl(tvShowsRemoteDataSource, tvShowLocaldataSource, tvShowCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ) : ArtistsRepository {
        return ArtistRepositoryImpl(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)
    }
}