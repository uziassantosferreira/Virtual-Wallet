package com.uzias.virtualwallet.welcome.domain.usecase

import com.uzias.virtualwallet.welcome.domain.repository.WelcomeRepository
import io.reactivex.Completable

class GenerateTokenImpl(val repository: WelcomeRepository) : GenerateToken {

    override fun run(): Completable = repository.generateToken()
}