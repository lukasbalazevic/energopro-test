package com.energopro.network.graphql.api

import com.energopro.network.graphql.GetEpisodesQuery
import com.energopro.network.graphql.client.ApiManager
import com.energopro.network.graphql.client.ApolloApiAdapter
import com.energopro.network.graphql.fragment.EpisodeFragment
import com.energopro.network.graphql.result.NetworkResult
import com.energopro.network.graphql.result.map
import org.koin.core.annotation.Single

@Single
internal class RickAndMortyApiImpl(
    override val apiAdapter: ApolloApiAdapter,
) : RickAndMortyApi, ApiManager {

    override suspend fun getEpisodes(): NetworkResult<List<EpisodeFragment>> = executeQuery(GetEpisodesQuery())
        .map { data ->
            val results = data.episodes?.results ?: emptyList()
            results.mapNotNull { result -> result?.episodeFragment }
        }
}
