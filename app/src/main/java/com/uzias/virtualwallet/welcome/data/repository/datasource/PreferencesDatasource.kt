package com.uzias.virtualwallet.welcome.data.repository.datasource

import io.reactivex.Completable
import io.reactivex.Maybe

interface PreferencesDatasource {

    fun saveToken(token: String) : Completable

    fun getToken() : Completable
}