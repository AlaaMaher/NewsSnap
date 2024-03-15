package com.alaa.newssnap

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alaa.newssnap.newsapp.presentation.navgraph.Route
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainVM : ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        viewModelScope.launch {
            startDestination = Route.AppStartNavigation.route
            delay(300)
            splashCondition = false
        }
    }


}