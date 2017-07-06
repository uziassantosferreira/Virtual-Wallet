package com.uzias.virtualwallet.welcome.di.module

import android.content.Context
import com.uzias.virtualwallet.welcome.data.repository.WelcomeRepositoryImpl
import com.uzias.virtualwallet.welcome.data.repository.datasource.LocalDatasource
import com.uzias.virtualwallet.welcome.data.repository.datasource.NetworkingDatasource
import com.uzias.virtualwallet.welcome.data.repository.datasource.PreferencesDatasource
import com.uzias.virtualwallet.welcome.data.repository.datasource.local.LocalDatasourceImpl
import com.uzias.virtualwallet.welcome.data.repository.datasource.networking.NetworkingDatasourceImpl
import com.uzias.virtualwallet.welcome.data.repository.datasource.networking.service.WelcomeService
import com.uzias.virtualwallet.welcome.data.repository.datasource.preferences.PreferencesDatasourceImpl
import com.uzias.virtualwallet.welcome.domain.repository.WelcomeRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class WelcomeDataModule {

    @Provides fun providesWelcomeRepository(localDatasource: LocalDatasource,
                                            networkingDatasource: NetworkingDatasource,
                                            preferencesDatasource: PreferencesDatasource): WelcomeRepository
            = WelcomeRepositoryImpl(localDatasource, networkingDatasource, preferencesDatasource)

    @Provides fun providesLocalDatasource(): LocalDatasource = LocalDatasourceImpl()

    @Provides fun providesNetworkingDatasource(welcomeService: WelcomeService): NetworkingDatasource
            = NetworkingDatasourceImpl(welcomeService)

    @Provides fun providesPreferencesDatasource(context: Context): PreferencesDatasource
            = PreferencesDatasourceImpl(context)

    @Provides fun providesWelcomeService(retrofit: Retrofit): WelcomeService
            = retrofit.create(WelcomeService::class.java)

}