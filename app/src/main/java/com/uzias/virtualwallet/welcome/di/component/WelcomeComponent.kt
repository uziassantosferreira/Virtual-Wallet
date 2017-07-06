package com.uzias.virtualwallet.welcome.di.component

import com.uzias.virtualwallet.core.di.AppComponent
import com.uzias.virtualwallet.welcome.di.module.WelcomeDataModule
import com.uzias.virtualwallet.welcome.di.module.WelcomePresentationModule
import com.uzias.virtualwallet.welcome.di.scope.WelcomeScope
import com.uzias.virtualwallet.welcome.presentation.view.WelcomeActivity
import dagger.Component

@WelcomeScope
@Component(modules = arrayOf(WelcomePresentationModule::class, WelcomeDataModule::class,
        WelcomePresentationModule::class), dependencies = arrayOf(AppComponent::class))
interface WelcomeComponent {

    fun inject(welcomeActivity: WelcomeActivity)

}