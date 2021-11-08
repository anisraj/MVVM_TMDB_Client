package com.example.mvvmtmdbclient.data.repositories.artist.datasourceImpl

import com.example.mvvmtmdbclient.data.model.artist.ArtistResponse
import com.example.mvvmtmdbclient.data.remote.api.TMDBServide
import com.example.mvvmtmdbclient.data.repositories.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistsRemoteSourceImpl(
    private val tmdbServide: TMDBServide,
    private val api_key: String
    ) : ArtistRemoteDataSource {

    override suspend fun getPopularArtists(): Response<ArtistResponse> {
        return tmdbServide.getPopularArtists(api_key)
    }
}