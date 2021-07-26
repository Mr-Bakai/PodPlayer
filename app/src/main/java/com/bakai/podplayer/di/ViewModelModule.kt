package com.bakai.podplayer.di

import com.bakai.podplayer.viewmodel.PodcastViewModel
import com.bakai.podplayer.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelModule = module {
    viewModel{ SearchViewModel(get()) }
    viewModel{ PodcastViewModel(get()) }
}