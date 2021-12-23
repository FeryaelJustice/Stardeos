package com.stardeos.stardeos.data.provider.network.stardeosapi

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StardeosAPIService @Inject constructor(private val api: StardeosAPIClient) {

    suspend fun get(): Any {
        return withContext(Dispatchers.IO) {
            val response = api.get()
            response.body() ?: emptyList()
        }
    }
}