package com.uzias.virtualwallet.welcome.data.repository.datasource.networking

import com.uzias.virtualwallet.welcome.data.repository.datasource.NetworkingDatasource
import com.uzias.virtualwallet.welcome.data.repository.datasource.networking.service.WelcomeService
import io.reactivex.Observable

class NetworkingDatasourceImpl(val welcomeService: WelcomeService) : NetworkingDatasource {

    override fun generateToken(name: String, email: String): Observable<String>
            = welcomeService.generateToken(name, email)

}