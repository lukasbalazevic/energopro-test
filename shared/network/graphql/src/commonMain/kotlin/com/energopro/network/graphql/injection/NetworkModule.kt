package com.energopro.network.graphql.injection

import com.energopro.network.graphql.client.ApolloClientFactory
import com.apollographql.apollo.ApolloClient
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.energopro.network.graphql")
class NetworkGraphqlModule {
    @Single
    fun apolloClient(factory: ApolloClientFactory): ApolloClient = factory.create()
}
