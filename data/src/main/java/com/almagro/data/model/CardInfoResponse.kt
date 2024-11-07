package com.almagro.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardInfoResponse(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("supertype") val supertype: String,
    @SerialName("subtypes") val subtypes: List<String>,
    @SerialName("level") val level: String? = null,
    @SerialName("hp") val hp: String,
    @SerialName("types") val types: List<String>,
    @SerialName("evolvesFrom") val evolvesFrom: String? = null,
    @SerialName("evolvesTo") val evolvesTo: List<String>? = null,
    @SerialName("abilities") val abilities: List<Ability>? = null,
    @SerialName("attacks") val attacks: List<Attack>? = null,
    @SerialName("weaknesses") val weaknesses: List<Weakness>? = null,
    @SerialName("resistances") val resistances: List<Resistance>? = null,
    @SerialName("retreatCost") val retreatCost: List<String>? = null,
    @SerialName("convertedRetreatCost") val convertedRetreatCost: Int? = null,
    @SerialName("set") val set: CardSet,
    @SerialName("number") val number: String,
    @SerialName("artist") val artist: String,
    @SerialName("rarity") val rarity: String? = null,
    @SerialName("flavorText") val flavorText: String? = null,
    @SerialName("nationalPokedexNumbers") val nationalPokedexNumbers: List<Int>,
    @SerialName("legalities") val legalities: Legalities,
    @SerialName("images") val images: Images,
    @SerialName("tcgplayer") val tcgplayer: TcgPlayer? = null,
    @SerialName("cardmarket") val cardmarket: CardMarket? = null,
    @SerialName("rules") val rules: List<String>? = null
)

@Serializable
data class Ability(
    @SerialName("name") val name: String,
    @SerialName("text") val text: String,
    @SerialName("type") val type: String
)

@Serializable
data class Attack(
    @SerialName("name") val name: String,
    @SerialName("cost") val cost: List<String>,
    @SerialName("convertedEnergyCost") val convertedEnergyCost: Int,
    @SerialName("damage") val damage: String? = null,
    @SerialName("text") val text: String? = null
)

@Serializable
data class Weakness(
    @SerialName("type") val type: String,
    @SerialName("value") val value: String
)

@Serializable
data class Resistance(
    @SerialName("type") val type: String,
    @SerialName("value") val value: String
)

@Serializable
data class CardSet(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("series") val series: String,
    @SerialName("printedTotal") val printedTotal: Int,
    @SerialName("total") val total: Int,
    @SerialName("legalities") val legalities: Legalities,
    @SerialName("ptcgoCode") val ptcgoCode: String? = null,
    @SerialName("releaseDate") val releaseDate: String,
    @SerialName("updatedAt") val updatedAt: String,
    @SerialName("images") val images: SetImages,
    @SerialName("regulationMark") val regulationMark: String? = null
)

@Serializable
data class Legalities(
    @SerialName("unlimited") val unlimited: String,
    @SerialName("expanded") val expanded: String? = null
)

@Serializable
data class SetImages(
    @SerialName("symbol") val symbol: String,
    @SerialName("logo") val logo: String
)

@Serializable
data class Images(
    @SerialName("small") val small: String,
    @SerialName("large") val large: String
)

@Serializable
data class TcgPlayer(
    @SerialName("url") val url: String,
    @SerialName("updatedAt") val updatedAt: String,
    @SerialName("prices") val prices: TcgPrices? = null
)

@Serializable
data class TcgPrices(
    @SerialName("normal") val normal: PriceDetails? = null,
    @SerialName("holofoil") val holofoil: PriceDetails? = null,
    @SerialName("reverseHolofoil") val reverseHolofoil: PriceDetails? = null
)

@Serializable
data class PriceDetails(
    @SerialName("low") val low: Double? = null,
    @SerialName("mid") val mid: Double? = null,
    @SerialName("high") val high: Double? = null,
    @SerialName("market") val market: Double? = null,
    @SerialName("directLow") val directLow: Double? = null
)

@Serializable
data class CardMarket(
    @SerialName("url") val url: String,
    @SerialName("updatedAt") val updatedAt: String,
    @SerialName("prices") val prices: CardMarketPrices
)

@Serializable
data class CardMarketPrices(
    @SerialName("averageSellPrice") val averageSellPrice: Double? = null,
    @SerialName("lowPrice") val lowPrice: Double? = null,
    @SerialName("trendPrice") val trendPrice: Double? = null,
    @SerialName("germanProLow") val germanProLow: Double? = null,
    @SerialName("suggestedPrice") val suggestedPrice: Double? = null,
    @SerialName("reverseHoloSell") val reverseHoloSell: Double? = null,
    @SerialName("reverseHoloLow") val reverseHoloLow: Double? = null,
    @SerialName("reverseHoloTrend") val reverseHoloTrend: Double? = null,
    @SerialName("lowPriceExPlus") val lowPriceExPlus: Double? = null,
    @SerialName("avg1") val avg1: Double? = null,
    @SerialName("avg7") val avg7: Double? = null,
    @SerialName("avg30") val avg30: Double? = null,
    @SerialName("reverseHoloAvg1") val reverseHoloAvg1: Double? = null,
    @SerialName("reverseHoloAvg7") val reverseHoloAvg7: Double? = null,
    @SerialName("reverseHoloAvg30") val reverseHoloAvg30: Double? = null
)
