package com.almagro.pokemontcgtactics.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.almagro.presentation.ui.CardListScreen
import com.almagro.presentation.ui.PokemonDetailScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoutes.POKEMON_LIST) {
        composable(NavRoutes.POKEMON_LIST) {
            CardListScreen { itemId ->
                navController.navigate("pokemonDetail/$itemId")
            }
        }

        composable(NavRoutes.POKEMON_DETAIL) { backStackEntry ->
            val cardId = backStackEntry.arguments?.getString("cardId") ?: return@composable
            PokemonDetailScreen(cardId = cardId, navController = navController)
        }
    }
}
