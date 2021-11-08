package com.example.mvvmtmdbclient.data.repositories.artist

import android.util.Log
import com.example.mvvmtmdbclient.data.model.artist.Artist
import com.example.mvvmtmdbclient.data.repositories.artist.datasource.ArtistCacheDataSource
import com.example.mvvmtmdbclient.data.repositories.artist.datasource.ArtistLocalDataSource
import com.example.mvvmtmdbclient.data.repositories.artist.datasource.ArtistRemoteDataSource
import com.example.mvvmtmdbclient.domain.repositories.ArtistsRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistsRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newLisArtists = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newLisArtists)
        artistCacheDataSource.saveArtistsToCache(newLisArtists)
        return newLisArtists
    }

    suspend fun getArtistsFromApi() : List<Artist> {
        lateinit var artistList : List<Artist>
        try {
            val response = artistRemoteDataSource.getPopularArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception : Exception) {
            Log.i("MyTAG", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB() : List<Artist> {
        lateinit var artistList : List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (exception : Exception) {
            Log.i("MyTAG", exception.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromApi()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache() : List<Artist> {
        lateinit var artistList : List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        } catch (exception : Exception) {
            Log.i("MyTAG", exception.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}