package com.example.mvvmtmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmtmdbclient.domain.use_cases.GetArtistsUseCase
import com.example.mvvmtmdbclient.domain.use_cases.UpdateArtistUseCase

class ArtistViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArtistViewModel::class.java)) {
            return ArtistViewModel(getArtistsUseCase, updateArtistUseCase) as T
        }
        throw IllegalArgumentException("no such class present")
    }
}