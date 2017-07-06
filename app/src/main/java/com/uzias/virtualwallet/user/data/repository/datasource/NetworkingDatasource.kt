package com.uzias.virtualwallet.user.data.repository.datasource

import io.reactivex.Observable

interface NetworkingDatasource {

    fun generateToken(name: String, email: String) : Observable<String>

}