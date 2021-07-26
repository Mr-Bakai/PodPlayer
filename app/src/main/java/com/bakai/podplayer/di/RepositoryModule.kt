package com.bakai.podplayer.di

import com.bakai.podplayer.repository.ItunesRepo
import com.bakai.podplayer.repository.PodcastRepo
import org.koin.dsl.module

val repositoryModule = module {
    single { PodcastRepo(get(), get()) }
    single { ItunesRepo(get()) }
}