package com.uzias.virtualwallet.welcome.di.module

import com.uzias.virtualwallet.welcome.domain.repository.WelcomeRepository
import com.uzias.virtualwallet.welcome.domain.usecase.GetCurrentUser
import com.uzias.virtualwallet.welcome.domain.usecase.GetCurrentUserImpl
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(WelcomeDataModule::class))
class WelcomeDomainModule {

    @Provides fun providesGetCurrentUser(welcomeRepository: WelcomeRepository): GetCurrentUser
            = GetCurrentUserImpl(welcomeRepository)


}