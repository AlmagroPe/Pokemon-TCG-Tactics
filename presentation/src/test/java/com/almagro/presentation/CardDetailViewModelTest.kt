package com.almagro.presentation

import com.almagro.domain.model.CardInfo
import com.almagro.domain.model.CardSet
import com.almagro.domain.model.Images
import com.almagro.domain.model.Legalities
import com.almagro.domain.model.SetImages
import com.almagro.domain.useCase.FetchCardDetailUseCase
import com.almagro.presentation.viewModel.CardDetailViewModel
import com.almagro.presentation.state.CardDetailViewState
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class CardDetailViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @MockK
    private lateinit var fetchCardDetailUseCase: FetchCardDetailUseCase

    private lateinit var viewModel: CardDetailViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        fetchCardDetailUseCase = FetchCardDetailUseCase(mockk())
        viewModel = CardDetailViewModel(fetchCardDetailUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testScope.cancel()
    }

    @Test
    fun `GIVEN a card detail WHEN fetchCardDetail THEN show the card detail successfully`() =
        testScope.runTest {
            coEvery { fetchCardDetailUseCase("123") } returns Result.success(mockCardInfo)

            viewModel.fetchCardDetail("123")

            val state = viewModel.pokemonCard.first()
            assertEquals(CardDetailViewState.Success(mockCardInfo), state)
        }

    @Test
    fun `GIVEN a card detail WHEN fetchCardDetail THEN show the card detail error`() =
        testScope.runTest {
            val errorMessage = "Card not found"
            coEvery { fetchCardDetailUseCase("123") } returns Result.failure(Exception(errorMessage))

            viewModel.fetchCardDetail("123")

            val state = viewModel.pokemonCard.first()
            assertEquals(CardDetailViewState.Error(errorMessage), state)
        }

    companion object {
        private val mockCardInfo = CardInfo(
            "123",
            "Pikachu",
            artist = "",
            hp = "",
            images = Images("", ""),
            legalities = Legalities("", ""),
            nationalPokedexNumbers = listOf(),
            number = "",
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
            ),
            subtypes = listOf(),
            supertype = "",
            types = listOf()
        )
    }
}
