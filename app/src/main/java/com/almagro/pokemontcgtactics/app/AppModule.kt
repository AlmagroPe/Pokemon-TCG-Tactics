package com.almagro.pokemontcgtactics.app

import com.almagro.data.di.DataModule
import com.almagro.domain.DomainModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [
    DataModule::class,
    DomainModule::class
])
@InstallIn(SingletonComponent::class)
object AppModule
