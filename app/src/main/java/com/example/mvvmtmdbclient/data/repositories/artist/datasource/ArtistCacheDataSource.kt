package com.example.mvvmtmdbclient.data.repositories.artist.datasource

import com.example.mvvmtmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache() : List<Artist>
    suspend fun saveArtistsToCache(movies: List<Artist>)
}