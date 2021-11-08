package com.example.mvvmtmdbclient.data.model.artist

import com.example.mvvmtmdbclient.data.model.artist.Artist
import com.google.gson.annotations.SerializedName

data class ArtistResponse(
    @SerializedName("results")
    val artists: List<Artist>
)
