package com.uzias.virtualwallet.user.data.repository.datasource.networking.service

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("GenerateToken")
    fun generateToken(@Query("name") name: String, @Query("email") email: String): Observable<String>

}