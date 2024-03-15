package com.alaa.newssnap.newsapp.presentation.navgraph

sealed class Route(val route: String) {
    object AuthenticationScreen: Route("authenticationScreen")
    object HomeScreen : Route("homeScreen")
    object DetailsScreen : Route("detailsScreen")
    object AppStartNavigation : Route("AppStartNavigation")
    object NewsNavigation : Route("newsNavigation")
    object NewsNavigatorScreen : Route("newsNavigatorScreen")




}