package com.alaa.newssnap.newsapp.presentation.navgraph

sealed class Route(val route: String) {
    object AuthenticationScreen: Route("authenticationScreen")
    object DetailsScreen : Route("detailsScreen")
    object AppStartNavigation : Route("AppStartNavigation")
    object NewsNavigatorScreen : Route("newsNavigatorScreen")




}