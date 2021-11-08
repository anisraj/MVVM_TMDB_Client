package com.example.mvvmtmdbclient.presentation.di

import android.content.Context
import com.example.mvvmtmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.mvvmtmdbclient.presentation.di.movie.MovieSubComponent
import com.example.mvvmtmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [
    MovieSubComponent::class,
    TvShowSubComponent::class,
    ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun providesAppContext() : Context {
        return context.applicationContext
    }
}