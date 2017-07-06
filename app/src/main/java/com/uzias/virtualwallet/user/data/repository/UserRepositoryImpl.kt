package com.uzias.virtualwallet.user.data.repository

import com.uzias.virtualwallet.user.data.repository.datasource.LocalDatasource
import com.uzias.virtualwallet.user.data.repository.datasource.NetworkingDatasource
import com.uzias.virtualwallet.user.data.repository.datasource.PreferencesDatasource
import com.uzias.virtualwallet.user.domain.model.User
import com.uzias.virtualwallet.user.domain.repository.UserRepository
import io.reactivex.Completable
import io.reactivex.Observable

class UserRepositoryImpl(val localDatasource: LocalDatasource,
                         val networkingDatasource: NetworkingDatasource,
                         val preferencesDatasource: PreferencesDatasource) : UserRepository {

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