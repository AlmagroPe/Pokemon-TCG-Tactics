package com.almagro.presentation.state

sealed class CardsViewState<out T> {
    object Loading : CardsViewState<Nothing>()
    data class Success<T>(val data: T) : CardsViewState<T>()
    data class Error(val message: String) : CardsViewState<Nothing>()
}
