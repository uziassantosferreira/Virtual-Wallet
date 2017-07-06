package com.uzias.virtualwallet.user.data.repository.datasource.networking

import com.uzias.virtualwallet.user.data.repository.datasource.NetworkingDatasource
import com.uzias.virtualwallet.user.data.repository.datasource.networking.service.UserService
import io.reactivex.Observable

class NetworkingDatasourceImpl(val userService: UserService) : NetworkingDatasource {

    override fun generateToken(name: String, email: String): Observable<String>
            = userService.generateToken(name, email)

}