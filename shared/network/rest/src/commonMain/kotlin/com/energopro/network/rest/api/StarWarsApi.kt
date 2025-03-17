package com.energopro.network.rest.api

import com.energopro.network.rest.dto.Person
import com.energopro.network.rest.result.NetworkResult
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path

interface StarWarsApi {

    @GET("people/{id}")
    suspend fun getPerson(
        @Path("id") personId: Int,
    ): NetworkResult<Person>
}
