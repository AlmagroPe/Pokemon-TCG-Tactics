package com.almagro.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.almagro.domain.model.CardInfo
import com.almagro.domain.useCase.FetchCardsUseCase
import com.almagro.presentation.state.CardsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardListViewModel
@Inject constructor(private val fetchCardsUseCase: FetchCardsUseCase) : ViewModel() {

    private val _pokemonCard = MutableStateFlow<CardsViewState<List<CardInfo>>>(CardsViewState.Loading)
    val pokemonCard: StateFlow<CardsViewState<List<CardInfo>>> = _pokemonCard

    fun fetchCards() {
        viewModelScope.launch {
            fetchCardsUseCase()
                .onSuccess {
                    _pokemonCard.value = CardsViewState.Success(it)
                }
                .onFailure {
                    _pokemonCard.value = CardsViewState.Error(it.message.orEmpty())
                }
        }
    }
}