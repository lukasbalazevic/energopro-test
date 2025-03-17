package com.energopro.network.graphql.api

import com.energopro.network.graphql.fragment.EpisodeFragment
import com.energopro.network.graphql.result.NetworkResult

interface RickAndMortyApi {
    suspend fun getEpisodes(): NetworkResult<List<EpisodeFragment>>
}
