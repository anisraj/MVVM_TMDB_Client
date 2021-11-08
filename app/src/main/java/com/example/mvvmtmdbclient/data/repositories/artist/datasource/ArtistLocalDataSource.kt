package com.example.mvvmtmdbclient.data.repositories.artist.datasource

import com.example.mvvmtmdbclient.data.model.artist.Artist


interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB() : List<Artist>
    suspend fun saveArtistsToDB(artists : List<Artist>)
    suspend fun clearAll()
}