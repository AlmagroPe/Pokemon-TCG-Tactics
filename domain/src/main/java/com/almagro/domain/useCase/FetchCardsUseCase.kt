package com.almagro.domain.useCase

import com.almagro.domain.repository.CardRepository
import javax.inject.Inject

class FetchCardsUseCase
@Inject constructor(private val repository: CardRepository) {

    suspend operator fun invoke() = repository.fetchCards()
}