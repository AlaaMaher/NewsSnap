package com.alaa.newssnap.newsapp.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import ccom.alaa.newssnap.newsapp.presentation.home.HomeViewModel
import com.alaa.newssnap.newsapp.domain.model.Article
import com.alaa.newssnap.newsapp.presentation.authentication.AuthenticationScreen
import com.alaa.newssnap.newsapp.presentation.details.DetailsScreen
import com.alaa.newssnap.newsapp.presentation.home.HomeScreen

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
                val viewModel: HomeViewModel = hiltViewModel()
                val topHeadlines = viewModel.topHeadlines.collectAsLazyPagingItems()

                val articles = viewModel.news.collectAsLazyPagingItems()
                HomeScreen(
                    topHeadlines = topHeadlines,
                    articles = articles,
                    navigateToDetails = {article ->
                        navigateToDetails(navController, article)
                    })

            }

            composable(route = Route.DetailsScreen.route) {
                navController.previousBackStackEntry?.savedStateHandle?.get<Article?>("article")
                    ?.let { article ->
                        DetailsScreen(
                            article = article,
                            navigateUp = { navController.navigateUp() })
                    }
            }

        }
    }

}

private fun navigateToNewsScreen(navController: NavController) {
    navController.navigate(
        route = Route.NewsNavigatorScreen.route
    )
}

private fun navigateToDetails(navController: NavController, article: Article) {
    navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
    navController.navigate(
        route = Route.DetailsScreen.route
    )
}


