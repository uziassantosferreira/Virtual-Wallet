package com.uzias.virtualwallet.welcome.data.repository.datasource.networking.service

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WelcomeService {

    @GET("GenerateToken")
    fun generateToken(@Query("name") name: String, @Query("email") email: String): Observable<String>

}