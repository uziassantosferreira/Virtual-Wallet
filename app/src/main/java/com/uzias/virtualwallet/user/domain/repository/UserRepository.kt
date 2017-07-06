package com.uzias.virtualwallet.user.domain.repository

import com.uzias.virtualwallet.user.domain.model.User
import io.reactivex.Completable
import io.reactivex.Observable

interface UserRepository {

    fun getCurrentUser() : Observable<User>

    fun generateToken(): Completable

}