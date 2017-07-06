package com.uzias.virtualwallet.user.domain.usecase

import com.uzias.virtualwallet.user.domain.repository.UserRepository
import io.reactivex.Completable

class GenerateTokenImpl(val repository: UserRepository) : GenerateToken {

    override fun run(): Completable = repository.generateToken()
}