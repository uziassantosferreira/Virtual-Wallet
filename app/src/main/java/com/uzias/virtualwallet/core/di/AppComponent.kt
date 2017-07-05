package com.uzias.virtualwallet.core.di

import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
@Singleton
interface AppComponent {

    fun retrofit(): Retrofit
}