package com.stardeos.stardeos.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    /*
    @Singleton
    @Inject
    lateinit var stardeosApp: Stardeos
     */
}