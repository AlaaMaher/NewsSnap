package com.alaa.newssnap.navgraph

sealed class Route(val route: String) {
    object FingerprintIdentificationScreen : Route("fingerprintIdentificationScreen")
    object HomeScreen : Route("homeScreen")
    object DetailsScreen : Route("detailsScreen")
    object AppStartNavigation : Route("AppStartNavigation")
    object NewsNavigation : Route("newsNavigation")
    object NewsNavigatorScreen : Route("newsNavigatorScreen")




}