package com.example.mvvmtmdbclient.presentation.di

import com.example.mvvmtmdbclient.data.remote.api.TMDBServide
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String ) {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideTmdbService(retrofit: Retrofit) : TMDBServide {
        return retrofit.create(TMDBServide::class.java)
    }
}