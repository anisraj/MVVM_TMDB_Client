package com.example.mvvmtmdbclient.data.repositories.artist.datasource

import com.example.mvvmtmdbclient.data.model.artist.ArtistResponse
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getPopularArtists() : Response<ArtistResponse>
}