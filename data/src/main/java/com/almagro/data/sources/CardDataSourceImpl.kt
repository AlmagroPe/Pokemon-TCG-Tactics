package com.almagro.data.sources

import com.almagro.data.model.CardInfoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CardDataSourceImpl
@Inject constructor(private val cardApi: CardApi) : CardDataSource {

    override suspend fun fetchCards(pageSize: Int): Result<List<CardInfoResponse>> =
        withContext(Dispatchers.IO) {
            try {
                val response = cardApi.getCards(pageSize)
                Result.success(response.data)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }

    override suspend fun fetchCardDetail(cardId: String): Result<CardInfoResponse> =
        withContext(Dispatchers.IO) {
            try {
                val response = cardApi.getCardDetail(cardId)
                Result.success(response.data[0])
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
}