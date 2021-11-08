package com.example.mvvmtmdbclient.presentation.di.tvshow

import com.example.mvvmtmdbclient.presentation.artist.ArtistActivity
import com.example.mvvmtmdbclient.presentation.movie.MovieActivity
import com.example.mvvmtmdbclient.presentation.tvshows.TvShowsActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowsActivity: TvShowsActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create() : TvShowSubComponent
    }
}