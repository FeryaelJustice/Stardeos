package com.stardeos.stardeos.di

import com.stardeos.stardeos.Stardeos
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,DataModule::class])
interface StardeosComponent{

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance app: Stardeos): StardeosComponent
    }
}