package com.uzias.virtualwallet.welcome.data.repository.datasource

import com.uzias.virtualwallet.welcome.domain.model.User
import io.reactivex.Observable

interface LocalDatasource {

    fun getCurrentUser() : Observable<User>

}