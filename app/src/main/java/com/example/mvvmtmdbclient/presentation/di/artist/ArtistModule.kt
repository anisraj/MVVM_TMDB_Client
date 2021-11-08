package com.example.mvvmtmdbclient.presentation.di.artist

import com.example.mvvmtmdbclient.domain.use_cases.GetArtistsUseCase
import com.example.mvvmtmdbclient.domain.use_cases.UpdateArtistUseCase
import com.example.mvvmtmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun providesArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ) : ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistUseCase)
    }
}