package com.uzias.virtualwallet.welcome.data.repository

import com.uzias.virtualwallet.welcome.data.repository.datasource.LocalDatasource
import com.uzias.virtualwallet.welcome.data.repository.datasource.NetworkingDatasource
import com.uzias.virtualwallet.welcome.data.repository.datasource.PreferencesDatasource
import com.uzias.virtualwallet.welcome.domain.model.User
import com.uzias.virtualwallet.welcome.domain.repository.WelcomeRepository
import io.reactivex.Completable
import io.reactivex.Observable

class WelcomeRepositoryImpl(val localDatasource: LocalDatasource,
                            val networkingDatasource: NetworkingDatasource,
                            val preferencesDatasource: PreferencesDatasource) : WelcomeRepository {

    override fun getCurrentUser(): Observable<User> = localDatasource.getCurrentUser()

    override fun generateToken(): Completable {
        getCurrentUser()
                .flatMap { networkingDatasource.generateToken(it.name, it.email) }
                .flatMapCompletable {
                    preferencesDatasource.saveToken(it)
                }
        return preferencesDatasource.getToken().onErrorResumeNext {
            getCurrentUser()
                    .flatMap { networkingDatasource.generateToken(it.name, it.email) }
                    .flatMapCompletable {
                        preferencesDatasource.saveToken(it)
                    }
        }

    }
}