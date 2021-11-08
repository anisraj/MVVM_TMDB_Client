package com.example.mvvmtmdbclient.data.repositories.artist.datasourceImpl
import com.example.mvvmtmdbclient.data.model.artist.Artist
import com.example.mvvmtmdbclient.data.repositories.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {

    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}