package com.uzias.virtualwallet.welcome.domain.repository

import com.uzias.virtualwallet.welcome.domain.model.User
import io.reactivex.Completable
import io.reactivex.Observable

interface WelcomeRepository {

    fun getCurrentUser() : Observable<User>

    fun generateToken(): Completable

}