package com.example.mvvmtmdbclient.domain.use_cases

import com.example.mvvmtmdbclient.data.model.tvshow.TvShow
import com.example.mvvmtmdbclient.domain.repositories.TvShowsRepository

class GetTvShowsUseCase(private val tvShowsRepository: TvShowsRepository) {
    suspend fun execute(): List<TvShow>? = tvShowsRepository.getTvshows()
}