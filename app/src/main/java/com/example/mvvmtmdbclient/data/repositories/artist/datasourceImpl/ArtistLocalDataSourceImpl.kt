package com.example.mvvmtmdbclient.data.repositories.artist.datasourceImpl

import com.example.mvvmtmdbclient.data.local.ArtistsDao
import com.example.mvvmtmdbclient.data.model.artist.Artist
import com.example.mvvmtmdbclient.data.repositories.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistsDao: ArtistsDao) : ArtistLocalDataSource {

    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistsDao.getAllArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistsDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistsDao.deleteAllArtists()
        }
    }
}