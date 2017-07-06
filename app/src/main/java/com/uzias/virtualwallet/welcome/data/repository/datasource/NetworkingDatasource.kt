package com.uzias.virtualwallet.welcome.data.repository.datasource

import io.reactivex.Observable

interface NetworkingDatasource {

    fun generateToken(name: String, email: String) : Observable<String>

}