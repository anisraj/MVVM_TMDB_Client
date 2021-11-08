package com.example.mvvmtmdbclient.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.mvvmtmdbclient.data.local.ArtistsDao
import com.example.mvvmtmdbclient.data.local.MovieDao
import com.example.mvvmtmdbclient.data.local.TMDBDatabase
import com.example.mvvmtmdbclient.data.local.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(context: Context) : TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdb_client")
            .build()
    }

    @Singleton
    @Provides
    fun providesMovieDao(tmdbDatabase: TMDBDatabase) : MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun providesTvShowsDao(tmdbDatabase: TMDBDatabase) : TvShowDao {
        return tmdbDatabase.tvShowsDao()
    }

    @Singleton
    @Provides
    fun providesArtistsDao(tmdbDatabase: TMDBDatabase) : ArtistsDao {
        return tmdbDatabase.artistsDao()
    }
}