package com.energopro.feature.domain

import app.futured.arkitekt.crusecases.UseCase
import com.energopro.network.rest.api.StarWarsApi
import com.energopro.network.rest.dto.Person
import com.energopro.network.rest.result.getOrThrow
import org.koin.core.annotation.Factory
import kotlin.random.Random

@Factory
internal class SyncDataUseCase(
    private val starWarsApi: StarWarsApi,
) : UseCase<Unit, Person>() {

    override suspend fun build(args: Unit): Person {
        return starWarsApi.getPerson(Random.nextInt(until = 100)).getOrThrow()
    }
}
