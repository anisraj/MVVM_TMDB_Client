package com.example.mvvmtmdbclient.presentation.di.tvshow

import com.example.mvvmtmdbclient.domain.use_cases.GetMoviesUseCase
import com.example.mvvmtmdbclient.domain.use_cases.GetTvShowsUseCase
import com.example.mvvmtmdbclient.domain.use_cases.UpdateMoviesUseCase
import com.example.mvvmtmdbclient.domain.use_cases.UpdateTvShowsUseCase
import com.example.mvvmtmdbclient.presentation.movie.MovieViewModelFactory
import com.example.mvvmtmdbclient.presentation.tvshows.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun providesTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ) : TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}