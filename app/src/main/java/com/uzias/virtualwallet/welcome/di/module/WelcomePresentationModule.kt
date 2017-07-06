package com.uzias.virtualwallet.welcome.di.module

import android.content.Context
import com.uzias.virtualwallet.user.domain.usecase.GenerateToken
import com.uzias.virtualwallet.user.domain.usecase.GetCurrentUser
import com.uzias.virtualwallet.welcome.presentation.navigation.Navigator
import com.uzias.virtualwallet.welcome.presentation.navigation.NavigatorImpl
import com.uzias.virtualwallet.welcome.presentation.presenter.WelcomePresenter
import com.uzias.virtualwallet.welcome.presentation.presenter.WelcomePresenterImpl
import dagger.Module
import dagger.Provides

@Module()
class WelcomePresentationModule {

    @Provides fun providesNavigator(context: Context): Navigator = NavigatorImpl(context)

    @Provides fun providesWelcomePresenter(getCurrentUser: GetCurrentUser,
                                           generateToken: GenerateToken,
                                           navigator: Navigator): WelcomePresenter
            = WelcomePresenterImpl(getCurrentUser, generateToken, navigator)

}