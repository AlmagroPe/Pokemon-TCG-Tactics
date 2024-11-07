package com.almagro.presentation.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.almagro.domain.model.CardInfo
import com.almagro.presentation.ErrorScreen
import com.almagro.presentation.LoadingScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailScreen(
    cardId: String,
    viewModel: CardDetailViewModel = hiltViewModel(),
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Pokemon Card Details", fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->

        val uiState by viewModel.pokemonCard.collectAsState()

        LaunchedEffect(cardId) {
            viewModel.fetchCardDetail(cardId)
        }

        Box(modifier = Modifier.padding(paddingValues)) {
            when (uiState) {
                CardDetailViewState.Loading -> LoadingScreen()
                is CardDetailViewState.Success -> DetailContent(
                    (uiState as CardDetailViewState.Success).data
                )

                is CardDetailViewState.Error -> ErrorScreen((uiState as CardDetailViewState.Error).message)
            }
        }
    }
}

@Composable
fun DetailContent(card: CardInfo) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = card.images.large,
            contentDescription = card.name,
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 16.dp)
        )
        Text(
            text = card.name,
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "HP: ${card.hp} • Type: ${card.types.joinToString(", ")}",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = card.flavorText ?: "No description available.",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Sell price: ${card.cardmarket?.prices?.averageSellPrice.toString()}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}