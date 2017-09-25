package org.mautokar.movieapp.inject

import dagger.Module
import dagger.Provides
import org.mautokar.movieapp.App
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideApp() = app
}
