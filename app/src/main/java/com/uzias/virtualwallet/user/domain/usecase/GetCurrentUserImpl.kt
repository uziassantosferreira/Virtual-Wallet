package com.uzias.virtualwallet.user.domain.usecase

import com.uzias.virtualwallet.user.domain.model.User
import com.uzias.virtualwallet.user.domain.repository.UserRepository
import io.reactivex.Observable

class GetCurrentUserImpl(val userRepository: UserRepository): GetCurrentUser {

    override fun run(): Observable<User> = userRepository.getCurrentUser()

}