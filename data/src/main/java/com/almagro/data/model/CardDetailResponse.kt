package com.almagro.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardDetailResponse(
    @SerialName("data") val data: List<CardInfoResponse>
)