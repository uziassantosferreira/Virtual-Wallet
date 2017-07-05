package com.uzias.virtualwallet.core.application

import android.app.Application
import com.uzias.virtualwallet.core.di.AppComponent
import com.uzias.virtualwallet.core.di.AppModule
import com.uzias.virtualwallet.core.di.DaggerAppComponent

class VirtualWalletApplication : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

}