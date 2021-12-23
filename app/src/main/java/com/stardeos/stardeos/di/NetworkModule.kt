package com.stardeos.stardeos.di

import com.stardeos.stardeos.data.provider.network.stardeosapi.StardeosAPIClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    @Named("BaseAPIURL")
    fun baseAPIURL() = "https://stardeos.com/api"

    // Provide Retrofit configuration
    @Singleton
    @Provides
    @Named("Retrofit")
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(baseAPIURL())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    @Named("ApiClient")
    fun provideAPIClient(retrofit: Retrofit): StardeosAPIClient {
        return retrofit.create(StardeosAPIClient::class.java)
    }
}