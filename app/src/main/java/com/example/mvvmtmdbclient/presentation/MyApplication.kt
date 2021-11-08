package com.example.mvvmtmdbclient.presentation

import android.app.Application
import com.bumptech.glide.util.Util
import com.example.mvvmtmdbclient.presentation.di.*
import com.example.mvvmtmdbclient.presentation.di.artist.ArtistSubComponent
import com.example.mvvmtmdbclient.presentation.di.movie.MovieSubComponent
import com.example.mvvmtmdbclient.presentation.di.tvshow.TvShowSubComponent
import com.example.mvvmtmdbclient.utils.Utils

class MyApplication : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(Utils.BASE_URL))
            .remoteDataModule(RemoteDataModule(Utils.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}