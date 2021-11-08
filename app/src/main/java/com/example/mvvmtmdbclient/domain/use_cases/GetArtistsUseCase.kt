package com.example.mvvmtmdbclient.domain.use_cases

import com.example.mvvmtmdbclient.data.model.artist.Artist
import com.example.mvvmtmdbclient.domain.repositories.ArtistsRepository

class GetArtistsUseCase(private val artistsRepository: ArtistsRepository) {
    suspend fun execute(): List<Artist>? = artistsRepository.getArtists()
}