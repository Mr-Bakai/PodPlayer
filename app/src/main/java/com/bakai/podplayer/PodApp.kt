package com.bakai.podplayer

import android.app.Application
import com.bakai.podplayer.di.dataBaseModule
import com.bakai.podplayer.di.networkModule
import com.bakai.podplayer.di.repositoryModule
import com.bakai.podplayer.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PodApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@PodApp)
            modules(provideModules())
        }
    }

    private fun provideModules() = listOf(
            viewModelModule,
            dataBaseModule,
            networkModule,
            repositoryModule
    )
}