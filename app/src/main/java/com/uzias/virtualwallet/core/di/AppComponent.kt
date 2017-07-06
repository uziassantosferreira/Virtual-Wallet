package com.uzias.virtualwallet.core.di

import android.content.Context
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
@Singleton
interface AppComponent {

    fun retrofit(): Retrofit

    fun context(): Context
}