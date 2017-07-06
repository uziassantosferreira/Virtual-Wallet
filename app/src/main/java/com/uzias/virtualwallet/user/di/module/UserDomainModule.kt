package com.uzias.virtualwallet.user.di.module

import com.uzias.virtualwallet.user.domain.repository.UserRepository
import com.uzias.virtualwallet.user.domain.usecase.GenerateToken
import com.uzias.virtualwallet.user.domain.usecase.GenerateTokenImpl
import com.uzias.virtualwallet.user.domain.usecase.GetCurrentUser
import com.uzias.virtualwallet.user.domain.usecase.GetCurrentUserImpl
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(UserDataModule::class))
class UserDomainModule {

    @Provides fun providesGetCurrentUser(userRepository: UserRepository): GetCurrentUser
            = GetCurrentUserImpl(userRepository)

    @Provides fun providesGenerateToken(userRepository: UserRepository): GenerateToken
            = GenerateTokenImpl(userRepository)
}