package com.uzias.virtualwallet.user.data.repository.datasource.local

import com.uzias.virtualwallet.user.data.repository.datasource.LocalDatasource
import com.uzias.virtualwallet.user.domain.model.User
import io.reactivex.Observable

class LocalDatasourceImpl : LocalDatasource {

    companion object {
        private val NAME = "Uzias Santos"
        private val EMAIL = "uziasferreira@gmail.com"
    }

    override fun getCurrentUser(): Observable<User> =
            Observable.just(User(name = NAME, email = EMAIL))

}