package com.example.mvvmtmdbclient.domain.repositories

import com.example.mvvmtmdbclient.data.model.artist.Artist

interface ArtistsRepository {

    suspend fun getArtists() : List<Artist>?
    suspend fun updateArtists() : List<Artist>?
}