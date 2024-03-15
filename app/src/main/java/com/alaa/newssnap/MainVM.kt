package com.alaa.newssnap

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alaa.newssnap.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainVM : ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set

    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

//    init {
//        appEntryUseCases.readAppEntryUseCase().onEach { shouldStartFromHomeScreen ->
//            if (shouldStartFromHomeScreen) {
//                startDestination = Route.NewsNavigation.route
//            } else {
//                startDestination = Route.AppStartNavigation.route
//            }
//            delay(300)
//            splashCondition = false
//        }.launchIn(viewModelScope)
//    }

}