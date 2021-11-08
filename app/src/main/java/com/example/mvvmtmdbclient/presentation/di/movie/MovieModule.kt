package com.example.mvvmtmdbclient.presentation.di.movie

import com.example.mvvmtmdbclient.domain.use_cases.GetMoviesUseCase
import com.example.mvvmtmdbclient.domain.use_cases.UpdateMoviesUseCase
import com.example.mvvmtmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun providesMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ) : MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}