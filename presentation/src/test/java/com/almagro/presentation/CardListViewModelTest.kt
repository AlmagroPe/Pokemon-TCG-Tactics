package com.almagro.presentation

import com.almagro.domain.model.CardInfo
import com.almagro.domain.model.CardSet
import com.almagro.domain.model.Images
import com.almagro.domain.model.Legalities
import com.almagro.domain.model.SetImages
import com.almagro.domain.useCase.FetchCardsUseCase
import com.almagro.presentation.viewModel.CardListViewModel
import com.almagro.presentation.state.CardDetailViewState
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class CardListViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @MockK
    private lateinit var fetchCardsUseCase: FetchCardsUseCase

    private lateinit var viewModel: CardListViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        fetchCardsUseCase = FetchCardsUseCase(mockk())
        viewModel = CardListViewModel(fetchCardsUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testScope.cancel()
    }

    @Test
    fun `GIVEN a card list WHEN fetchCards THEN show the card detail successfully`() =
        testScope.runTest {
            val mockCardInfo = listOf(
                CardInfo(
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
            )
            coEvery { fetchCardsUseCase() } returns Result.success(mockCardInfo)

            viewModel.fetchCards()

            val state = viewModel.pokemonCard.first()
            assertEquals(CardDetailViewState.Success(mockCardInfo), state)
        }

    @Test
    fun `GIVEN a card detail WHEN fetchCardDetail THEN show the card detail error`() =
        testScope.runTest {
            val errorMessage = "Card not found"
            coEvery { fetchCardsUseCase() } returns Result.failure(Exception(errorMessage))

            viewModel.fetchCards()

            val state = viewModel.pokemonCard.first()
            assertEquals(CardDetailViewState.Error(errorMessage), state)
        }
}
