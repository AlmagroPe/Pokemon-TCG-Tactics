package com.almagro.data.sources

import com.almagro.data.model.CardInfoResponse

interface CardDataSource {

    suspend fun fetchCards(pageSize: Int, page: Int): Result<List<CardInfoResponse>>

    suspend fun fetchCardDetail(cardId: String): Result<CardInfoResponse>
}