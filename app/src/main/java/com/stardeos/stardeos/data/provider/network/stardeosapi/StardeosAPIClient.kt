package com.stardeos.stardeos.data.provider.network.stardeosapi

import com.stardeos.stardeos.data.model.Stardust
import retrofit2.Response
import retrofit2.http.GET

interface StardeosAPIClient {
    @GET("/")
    suspend fun get(): Response<List<Stardust>>
}