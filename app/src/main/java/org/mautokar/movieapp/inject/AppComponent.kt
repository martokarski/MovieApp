package org.mautokar.movieapp.inject

import dagger.Component
import org.mautokar.movieapp.ui.activity.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, ServiceModule::class))
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}
