package com.uzias.virtualwallet.welcome.data.repository

import com.uzias.virtualwallet.welcome.data.repository.datasource.LocalDatasource
import com.uzias.virtualwallet.welcome.domain.model.User
import com.uzias.virtualwallet.welcome.domain.repository.WelcomeRepository
import io.reactivex.Observable

class WelcomeRepositoryImpl(val localDatasource: LocalDatasource) : WelcomeRepository {

    override fun getCurrentUser(): Observable<User> = localDatasource.getCurrentUser()

}