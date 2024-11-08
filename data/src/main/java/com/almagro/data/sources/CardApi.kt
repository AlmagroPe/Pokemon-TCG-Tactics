package com.almagro.data.sources

import com.almagro.data.model.CardDetailResponse
import com.almagro.data.model.CardsResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface CardApi {

    @Headers("Accept: application/json")
    @GET("cards")
    suspend fun getCards(@Header("pageSize") pageSize: Int, @Header("page") page: Int): CardsResponse

    @Headers("Accept: application/json")
    @GET("cards")
    suspend fun getCardDetail(@Header("id") cardId: String): CardDetailResponse
}
