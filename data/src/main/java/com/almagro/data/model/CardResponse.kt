package com.almagro.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardsResponse(
    @SerialName("data") val data: List<CardInfoResponse>,
    @SerialName("page") val page: Int,
    @SerialName("pageSize") val pageSize: Int,
    @SerialName("count") val count: Int,
    @SerialName("totalCount") val totalCount: Int
)