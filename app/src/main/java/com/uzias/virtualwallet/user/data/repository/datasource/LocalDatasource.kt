package com.uzias.virtualwallet.user.data.repository.datasource

import com.uzias.virtualwallet.user.domain.model.User
import io.reactivex.Observable

interface LocalDatasource {

    fun getCurrentUser() : Observable<User>

}