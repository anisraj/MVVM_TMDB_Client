package com.example.mvvmtmdbclient.presentation.di.movie

import com.example.mvvmtmdbclient.presentation.artist.ArtistActivity
import com.example.mvvmtmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create() : MovieSubComponent
    }
}