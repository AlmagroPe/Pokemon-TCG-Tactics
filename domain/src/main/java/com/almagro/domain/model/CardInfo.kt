package com.almagro.domain.model

data class CardInfo(
    val id: String,
    val name: String,
    val supertype: String,
    val subtypes: List<String>,
    val level: String? = null,
    val hp: String,
    val types: List<String>,
    val evolvesFrom: String? = null,
    val evolvesTo: List<String>? = null,
    val abilities: List<Ability>? = null,
    val attacks: List<Attack>? = null,
    val weaknesses: List<Weakness>? = null,
    val resistances: List<Resistance>? = null,
    val retreatCost: List<String>? = null,
    val convertedRetreatCost: Int? = null,
    val set: CardSet,
    val number: String,
    val artist: String,
    val rarity: String? = null,
    val flavorText: String? = null,
    val nationalPokedexNumbers: List<Int>,
    val legalities: Legalities,
    val images: Images,
    val tcgplayer: TcgPlayer? = null,
    val cardmarket: CardMarket? = null,
    val rules: List<String>? = null
)

data class Ability(
    val name: String,
    val text: String,
    val type: String
)

data class Attack(
    val name: String,
    val cost: List<String>,
    val convertedEnergyCost: Int,
    val damage: String? = null,
    val text: String? = null
)

data class Weakness(
    val type: String,
    val value: String
)

data class Resistance(
    val type: String,
    val value: String
)

data class CardSet(
    val id: String,
    val name: String,
    val series: String,
    val printedTotal: Int,
    val total: Int,
    val legalities: Legalities,
    val ptcgoCode: String? = null,
    val releaseDate: String,
    val updatedAt: String,
    val images: SetImages,
    val regulationMark: String? = null
)

data class Legalities(
    val unlimited: String,
    val expanded: String? = null
)

data class SetImages(
    val symbol: String,
    val logo: String
)

data class Images(
    val small: String,
    val large: String
)

data class TcgPlayer(
    val url: String,
    val updatedAt: String,
    val prices: TcgPrices? = null
)

data class TcgPrices(
    val normal: PriceDetails? = null,
    val holofoil: PriceDetails? = null,
    val reverseHolofoil: PriceDetails? = null
)

data class PriceDetails(
    val low: Double? = null,
    val mid: Double? = null,
    val high: Double? = null,
    val market: Double? = null,
    val directLow: Double? = null
)

data class CardMarket(
    val url: String,
    val updatedAt: String,
    val prices: CardMarketPrices
)

data class CardMarketPrices(
    val averageSellPrice: Double? = null,
    val lowPrice: Double? = null,
    val trendPrice: Double? = null,
    val germanProLow: Double? = null,
    val suggestedPrice: Double? = null,
    val reverseHoloSell: Double? = null,
    val reverseHoloLow: Double? = null,
    val reverseHoloTrend: Double? = null,
    val lowPriceExPlus: Double? = null,
    val avg1: Double? = null,
    val avg7: Double? = null,
    val avg30: Double? = null,
    val reverseHoloAvg1: Double? = null,
    val reverseHoloAvg7: Double? = null,
    val reverseHoloAvg30: Double? = null
)
