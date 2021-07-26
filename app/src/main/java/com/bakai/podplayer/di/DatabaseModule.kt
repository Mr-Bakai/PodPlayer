package com.bakai.podplayer.di

import com.bakai.podplayer.db.PodPlayDatabase
import org.koin.dsl.module

val dataBaseModule = module {
    single { PodPlayDatabase.getInstance(get()) }
    single { get<PodPlayDatabase>().podcastDao() }
}