package org.mautokar.movieapp

import android.app.Application
import org.mautokar.movieapp.inject.AppComponent
import org.mautokar.movieapp.inject.AppModule
import org.mautokar.movieapp.inject.DaggerAppComponent

class App : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}
