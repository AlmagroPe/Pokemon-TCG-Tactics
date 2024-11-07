package com.almagro.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.almagro.domain.model.CardInfo
import com.almagro.domain.useCase.FetchCardDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardDetailViewModel
@Inject constructor(private val fetchCardDetailUseCase: FetchCardDetailUseCase) : ViewModel() {

    private val _pokemonCard =
        MutableStateFlow<CardDetailViewState<CardInfo>>(CardDetailViewState.Loading)
    val pokemonCard: StateFlow<CardDetailViewState<CardInfo>> = _pokemonCard

    fun fetchCardDetail(cardId: String) {
        viewModelScope.launch {
            fetchCardDetailUseCase(cardId)
                .onSuccess {
                    _pokemonCard.value = CardDetailViewState.Success(it)
                }
                .onFailure {
                    _pokemonCard.value = CardDetailViewState.Error(it.message.orEmpty())
                }
        }
    }
}