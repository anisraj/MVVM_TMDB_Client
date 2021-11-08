package com.example.mvvmtmdbclient.presentation.di

import com.example.mvvmtmdbclient.domain.repositories.ArtistsRepository
import com.example.mvvmtmdbclient.domain.repositories.MovieRepository
import com.example.mvvmtmdbclient.domain.repositories.TvShowsRepository
import com.example.mvvmtmdbclient.domain.use_cases.*
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun getMoviesUseCase(movieRepository: MovieRepository) : GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun updateMoviesUseCase(movieRepository: MovieRepository) : UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun getTvShowsUseCase(tvShowsRepository: TvShowsRepository) : GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowsRepository)
    }
    @Provides
    fun updateTvShowsUseCase(tvShowsRepository: TvShowsRepository) : UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowsRepository)
    }

    @Provides
    fun getArtistsUseCase(artistsRepository: ArtistsRepository) : GetArtistsUseCase {
        return GetArtistsUseCase(artistsRepository)
    }
    @Provides
    fun updateArtistsUseCase(artistsRepository: ArtistsRepository) : UpdateArtistUseCase {
        return UpdateArtistUseCase(artistsRepository)
    }

}