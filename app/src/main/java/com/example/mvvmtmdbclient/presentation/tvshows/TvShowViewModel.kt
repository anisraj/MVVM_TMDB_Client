package com.example.mvvmtmdbclient.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmtmdbclient.domain.use_cases.GetTvShowsUseCase
import com.example.mvvmtmdbclient.domain.use_cases.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShows = getTvShowsUseCase.execute()
        emit(tvShows)
    }

    fun updateTvshows() = liveData {
        val tvShows = updateTvShowsUseCase.execute()
        emit(tvShows)
    }
}