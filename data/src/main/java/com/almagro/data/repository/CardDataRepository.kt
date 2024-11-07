package com.almagro.data.repository

import com.almagro.data.model.CardInfoMapper.cardInfoToDomain
import com.almagro.data.sources.CardDataSource
import com.almagro.domain.model.CardInfo
import com.almagro.domain.repository.CardRepository
import javax.inject.Inject

class CardDataRepository
@Inject constructor(private val cardDataSource: CardDataSource) : CardRepository {

    private var pageSize = 10

    override suspend fun fetchCards(): Result<List<CardInfo>> =
        cardDataSource.fetchCards(pageSize)
            .map { cards ->
                pageSize += 10
                cards.map { cardInfoToDomain(it) }
            }.onFailure {
                pageSize = 0
            }

    override suspend fun fetchCardDetail(cardId: String): Result<CardInfo> =
        cardDataSource.fetchCardDetail(cardId).map { cardInfoToDomain(it) }
}