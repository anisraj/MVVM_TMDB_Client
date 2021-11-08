package com.example.mvvmtmdbclient.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmtmdbclient.data.model.artist.Artist
import com.example.mvvmtmdbclient.data.model.movie.Movie
import com.example.mvvmtmdbclient.data.model.tvshow.TvShow

@Database(entities = [Artist::class, Movie::class, TvShow::class]
    , version = 1
    , exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDao
    abstract fun tvShowsDao() : TvShowDao
    abstract fun artistsDao() : ArtistsDao
}