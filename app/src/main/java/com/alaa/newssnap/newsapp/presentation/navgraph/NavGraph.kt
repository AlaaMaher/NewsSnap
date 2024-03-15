package com.alaa.newssnap.newsapp.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.alaa.newssnap.newsapp.presentation.authentication.AuthenticationScreen

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.AuthenticationScreen.route
        ) {
            composable(route = Route.AuthenticationScreen.route) {
                AuthenticationScreen(navigateToHomeScreen =
                { navigateToNewsScreen(navController) }
                )
            }

            composable(route = Route.NewsNavigatorScreen.route) {

            }

            composable(route = Route.DetailsScreen.route) {

            }

        }
    }

}

private fun navigateToNewsScreen(navController: NavController) {
    navController.navigate(
        route = Route.NewsNavigatorScreen.route
    )
}


