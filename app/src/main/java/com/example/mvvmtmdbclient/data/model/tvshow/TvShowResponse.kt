package com.example.mvvmtmdbclient.data.model.tvshow

import com.example.mvvmtmdbclient.data.model.tvshow.TvShow
import com.google.gson.annotations.SerializedName

data class TvShowResponse(
    @SerializedName("results")
    val tvShows: List<TvShow>
)
