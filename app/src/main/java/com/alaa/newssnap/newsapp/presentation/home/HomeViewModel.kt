package ccom.alaa.newssnap.newsapp.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.alaa.newssnap.newsapp.domain.usecase.newsUseCases.NewsUseCases
import com.alaa.newssnap.newsapp.presentation.home.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {


    private var _homeState = mutableStateOf(HomeState())
    val homeState: State<HomeState> = _homeState

    val topHeadlines = newsUseCases.topHeadlines(
        sources = _homeState.value.source
    ).cachedIn(viewModelScope)


    val news = newsUseCases.getNewsUseCase(
        sources = _homeState.value.source
    ).cachedIn(viewModelScope)

}