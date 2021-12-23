package com.stardeos.stardeos.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    /*
    @Singleton
    @Inject
    lateinit var stardeosApp: Stardeos
     */
}