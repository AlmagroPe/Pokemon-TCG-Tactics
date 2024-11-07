package com.almagro.domain

import com.almagro.domain.repository.CardRepository
import com.almagro.domain.useCase.FetchCardDetailUseCase
import com.almagro.domain.useCase.FetchCardsUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideFetchCardDetailUseCase(repository: CardRepository): FetchCardDetailUseCase =
        FetchCardDetailUseCase(repository)

    @Provides
    @Singleton
    fun provideFetchCardsUseCase(repository: CardRepository): FetchCardsUseCase =
        FetchCardsUseCase(repository)
}