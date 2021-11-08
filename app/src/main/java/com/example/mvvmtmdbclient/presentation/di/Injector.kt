package com.example.mvvmtmdbclient.presentation.di

import com.example.mvvmtmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.mvvmtmdbclient.presentation.di.movie.MovieSubComponent
import com.example.mvvmtmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent() : MovieSubComponent
    fun createTvShowSubComponent() : TvShowSubComponent
    fun createArtistSubComponent() : ArtistSubComponent
}