package com.almagro.domain.repository

import com.almagro.domain.model.CardInfo

interface CardRepository {

    suspend fun fetchCards(): Result<List<CardInfo>>

    suspend fun fetchCardDetail(cardId: String): Result<CardInfo>
}