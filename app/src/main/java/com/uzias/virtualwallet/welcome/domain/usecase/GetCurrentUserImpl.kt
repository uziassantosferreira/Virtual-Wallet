package com.uzias.virtualwallet.welcome.domain.usecase

import com.uzias.virtualwallet.welcome.domain.model.User
import com.uzias.virtualwallet.welcome.domain.repository.WelcomeRepository
import io.reactivex.Observable

class GetCurrentUserImpl(val welcomeRepository: WelcomeRepository): GetCurrentUser {

    override fun run(): Observable<User> = welcomeRepository.getCurrentUser()

}