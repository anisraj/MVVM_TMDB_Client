package com.example.mvvmtmdbclient.presentation.di

import com.example.mvvmtmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.mvvmtmdbclient.presentation.di.movie.MovieSubComponent
import com.example.mvvmtmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    UseCasesModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
])
interface AppComponent {

    fun movieSubComponent() : MovieSubComponent.Factory
    fun tvShowSubComponent() : TvShowSubComponent.Factory
    fun artistSubComponent() : ArtistSubComponent.Factory
}