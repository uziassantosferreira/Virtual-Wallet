package com.uzias.virtualwallet.welcome.data.repository.datasource.local

import com.uzias.virtualwallet.welcome.data.repository.datasource.LocalDatasource
import com.uzias.virtualwallet.welcome.domain.model.User
import io.reactivex.Observable

class LocalDatasourceImpl : LocalDatasource {

    override fun getCurrentUser(): Observable<User> =
            Observable.just(User(name = "Uzias Santos", email = "uziasferreira@gmail.com"))

}