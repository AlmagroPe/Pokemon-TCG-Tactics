package com.almagro.data.model

import com.almagro.domain.model.CardInfo as Card
import com.almagro.domain.model.Ability as AbilityDomain
import com.almagro.domain.model.Attack as AttackDomain
import com.almagro.domain.model.Weakness as WeaknessDomain
import com.almagro.domain.model.Resistance as ResistanceDomain
import com.almagro.domain.model.CardSet as CardSetDomain
import com.almagro.domain.model.Legalities as LegalitiesDomain
import com.almagro.domain.model.SetImages as SetImagesDomain
import com.almagro.domain.model.Images as ImagesDomain
import com.almagro.domain.model.TcgPlayer as TcgPlayerDomain
import com.almagro.domain.model.TcgPrices as TcgPricesDomain
import com.almagro.domain.model.PriceDetails as PriceDetailsDomain
import com.almagro.domain.model.CardMarket as CardMarketDomain
import com.almagro.domain.model.CardMarketPrices as CardMarketPricesDomain

object CardInfoMapper {

    fun cardInfoToDomain(cardInfoResponse: CardInfoResponse): Card =
            Card(
                id = cardInfoResponse.id,
                name = cardInfoResponse.name,
                supertype = cardInfoResponse.supertype,
                subtypes = cardInfoResponse.subtypes,
                level = cardInfoResponse.level,
                hp = cardInfoResponse.hp,
                types = cardInfoResponse.types,
                evolvesFrom = cardInfoResponse.evolvesFrom,
                evolvesTo = cardInfoResponse.evolvesTo,
                abilities = cardInfoResponse.abilities?.toDomainAbility(),
                attacks = cardInfoResponse.attacks?.toDomainAttack(),
                weaknesses = cardInfoResponse.weaknesses?.toDomainWeakness(),
                resistances = cardInfoResponse.resistances?.toDomainResistance(),
                convertedRetreatCost = cardInfoResponse.convertedRetreatCost,
                set = cardInfoResponse.set.toDomain(),
                number = cardInfoResponse.number,
                artist = cardInfoResponse.artist,
                rarity = cardInfoResponse.rarity,
                flavorText = cardInfoResponse.flavorText,
                nationalPokedexNumbers = cardInfoResponse.nationalPokedexNumbers,
                legalities = cardInfoResponse.legalities.toDomain(),
                images = cardInfoResponse.images.toDomain(),
                tcgplayer = cardInfoResponse.tcgplayer?.toDomain(),
                cardmarket = cardInfoResponse.cardmarket?.toDomain(),
                rules = cardInfoResponse.rules,
            )

    private fun List<Ability>.toDomainAbility(): List<AbilityDomain> =
        map { ability ->
            AbilityDomain(
                name = ability.name,
                text = ability.text,
                type = ability.type
            )
        }

    private fun List<Attack>.toDomainAttack(): List<AttackDomain> =
        map { attack ->
            AttackDomain(
                name = attack.name,
                cost = attack.cost,
                text = attack.text,
                convertedEnergyCost = attack.convertedEnergyCost,
                damage = attack.damage
            )
        }

    private fun List<Weakness>.toDomainWeakness(): List<WeaknessDomain> =
        map { weakness ->
            WeaknessDomain(
                type = weakness.type,
                value = weakness.value
            )
        }

    private fun List<Resistance>.toDomainResistance(): List<ResistanceDomain> =
        map { resistance ->
            ResistanceDomain(
                type = resistance.type,
                value = resistance.value
            )
        }

    private fun CardSet.toDomain(): CardSetDomain =
        CardSetDomain(
            id = id,
            name = name,
            series = series,
            printedTotal = printedTotal,
            total = total,
            legalities = legalities.toDomain(),
            ptcgoCode = ptcgoCode,
            releaseDate = releaseDate,
            updatedAt = updatedAt,
            images = images.toDomain(),
            regulationMark = regulationMark
        )

    private fun Legalities.toDomain(): LegalitiesDomain =
        LegalitiesDomain(
            unlimited = unlimited,
            expanded = expanded
        )

    private fun SetImages.toDomain(): SetImagesDomain =
        SetImagesDomain(
            symbol = symbol,
            logo = logo
        )

    private fun Images.toDomain(): ImagesDomain =
        ImagesDomain(
            small = small,
            large = large
        )

    private fun TcgPlayer?.toDomain(): TcgPlayerDomain =
        TcgPlayerDomain(
            url = this?.url.orEmpty(),
            updatedAt = this?.updatedAt.orEmpty(),
            prices = this?.prices.toDomain()
        )

    private fun TcgPrices?.toDomain(): TcgPricesDomain =
        TcgPricesDomain(
            normal = this?.normal?.toDomain(),
            holofoil = this?.holofoil?.toDomain(),
            reverseHolofoil = this?.reverseHolofoil?.toDomain()
        )

    private fun PriceDetails?.toDomain(): PriceDetailsDomain =
        PriceDetailsDomain(
            low = this?.low,
            mid = this?.mid,
            high = this?.high,
            market = this?.market,
            directLow = this?.directLow
        )

    private fun CardMarket?.toDomain(): CardMarketDomain =
        CardMarketDomain(
            url = this?.url.orEmpty(),
            updatedAt = this?.updatedAt.orEmpty(),
            prices = this?.prices.toDomain()
        )

    private fun CardMarketPrices?.toDomain(): CardMarketPricesDomain =
        CardMarketPricesDomain(
            averageSellPrice = this?.averageSellPrice,
            lowPrice = this?.lowPrice,
            trendPrice = this?.trendPrice,
            germanProLow = this?.germanProLow,
            suggestedPrice = this?.suggestedPrice,
            reverseHoloSell = this?.reverseHoloSell,
            reverseHoloLow = this?.reverseHoloLow,
            reverseHoloTrend = this?.reverseHoloTrend,
            lowPriceExPlus = this?.lowPriceExPlus,
            avg1 = this?.avg1,
            avg7 = this?.avg7,
            avg30 = this?.avg30,
            reverseHoloAvg1 = this?.reverseHoloAvg1,
            reverseHoloAvg7 = this?.reverseHoloAvg7,
            reverseHoloAvg30 = this?.reverseHoloAvg30
        )
}