package com.example.mvvmtmdbclient.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmtmdbclient.domain.use_cases.GetTvShowsUseCase
import com.example.mvvmtmdbclient.domain.use_cases.UpdateTvShowsUseCase

class TvShowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TvShowViewModel::class.java)) {
            return TvShowViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
        }
        throw IllegalArgumentException("no such class")
    }
}