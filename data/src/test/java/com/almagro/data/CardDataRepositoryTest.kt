package com.almagro.data

import com.almagro.data.model.CardInfoResponse
import com.almagro.data.model.CardSet
import com.almagro.data.model.Images
import com.almagro.data.model.Legalities
import com.almagro.data.model.SetImages
import com.almagro.data.repository.CardDataRepository
import com.almagro.data.sources.CardDataSource
import com.almagro.domain.model.CardInfo
import com.almagro.domain.repository.CardRepository
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class CardDataRepositoryTest {

    @MockK
    private lateinit var cardDataSource: CardDataSource

    private lateinit var cardRepository: CardRepository

    @Before
    fun setUp() {
        cardDataSource = mockk()
        cardRepository = CardDataRepository(cardDataSource)
    }

    @Test
    fun `GIVEN get cards WHEN call fetch Cards THEN return a list of CardInfo`() = runTest {
        coEvery { cardDataSource.fetchCards(10) } returns Result.success(mockCardInfoList)

        val result = cardRepository.fetchCards()

        assert(result.isSuccess)
        assertEquals(mockExpectedList, result.getOrNull())
    }

    @Test
    fun `GIVEN get card detail WHEN fetchCardDetail THEN should return CardInfo on success`() = runTest {
        coEvery { cardDataSource.fetchCardDetail("123") } returns Result.success(mockCardInfo)

        val result = cardRepository.fetchCardDetail("123")

        assert(result.isSuccess)
        assertEquals(mockExpectedCardInfo, result.getOrNull())
    }

    @Test
    fun `GIVEN get CardDetail WHEN fetchCardDetail THEN return failure on error`() = runTest {
        coEvery { cardDataSource.fetchCardDetail("1") } returns Result.failure(Exception("Card not found"))

        val result = cardRepository.fetchCardDetail("1")

        assert(result.isFailure)
        assertEquals("Card not found", result.exceptionOrNull()?.message)
    }

    companion object {
        private val mockCardInfoList = listOf(
            CardInfoResponse(
                "123",
                "Pikachu",
                artist = "",
                hp = "",
                images = Images("", ""),
                legalities = Legalities("", ""),
                nationalPokedexNumbers = listOf(),
                number = "",
                subtypes = listOf(),
                supertype = "",
                types = listOf(),
                set = CardSet(
                    "",
                    "",
                    "",
                    0,
                    0,
                    Legalities("", ""),
                    images = SetImages("", ""),
                    releaseDate = "",
                    updatedAt = ""
                )
            )
        )

        private val mockExpectedList = listOf(
            CardInfo(
                "123",
                "Pikachu",
                artist = "",
                hp = "",
                images = com.almagro.domain.model.Images("", ""),
                legalities = com.almagro.domain.model.Legalities("", ""),
                nationalPokedexNumbers = listOf(),
                number = "",
                set = com.almagro.domain.model.CardSet(
                    "",
                    "",
                    "",
                    0,
                    0,
                    com.almagro.domain.model.Legalities("", ""),
                    images = com.almagro.domain.model.SetImages("", ""),
                    releaseDate = "",
                    updatedAt = ""
                ),
                subtypes = listOf(),
                supertype = "",
                types = listOf()
            )
        )

        private val mockCardInfo =
            CardInfoResponse(
                "123",
                "Pikachu",
                artist = "",
                hp = "",
                images = Images("", ""),
                legalities = Legalities("", ""),
                nationalPokedexNumbers = listOf(),
                number = "",
                subtypes = listOf(),
                supertype = "",
                types = listOf(),
                set = CardSet(
                    "",
                    "",
                    "",
                    0,
                    0,
                    Legalities("", ""),
                    images = SetImages("", ""),
                    releaseDate = "",
                    updatedAt = ""
                )
            )

        private val mockExpectedCardInfo =
            CardInfo(
                "123",
                "Pikachu",
                artist = "",
                hp = "",
                images = com.almagro.domain.model.Images("", ""),
                legalities = com.almagro.domain.model.Legalities("", ""),
                nationalPokedexNumbers = listOf(),
                number = "",
                set = com.almagro.domain.model.CardSet(
                    "",
                    "",
                    "",
                    0,
                    0,
                    com.almagro.domain.model.Legalities("", ""),
                    images = com.almagro.domain.model.SetImages("", ""),
                    releaseDate = "",
                    updatedAt = ""
                ),
                subtypes = listOf(),
                supertype = "",
                types = listOf()
            )
    }
}
