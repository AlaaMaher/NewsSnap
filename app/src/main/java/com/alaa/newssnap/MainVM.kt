package com.alaa.newssnap

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.alaa.newssnap.newsapp.presentation.navgraph.Route


class MainVM: ViewModel() {

    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set


}