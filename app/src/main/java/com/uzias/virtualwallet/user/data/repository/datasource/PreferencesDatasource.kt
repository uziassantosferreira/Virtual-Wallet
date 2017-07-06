package com.uzias.virtualwallet.user.data.repository.datasource

import io.reactivex.Completable
import io.reactivex.Maybe

interface PreferencesDatasource {

    fun saveToken(token: String) : Completable

    fun getToken() : Completable
}