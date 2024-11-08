package com.almagro.presentation.state

sealed class CardDetailViewState<out T> {
    object Loading : CardDetailViewState<Nothing>()
    data class Success<T>(val data: T) : CardDetailViewState<T>()
    data class Error(val message: String) : CardDetailViewState<Nothing>()
}