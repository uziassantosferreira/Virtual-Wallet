package com.uzias.virtualwallet.welcome.di.module

import com.uzias.virtualwallet.welcome.data.repository.WelcomeRepositoryImpl
import com.uzias.virtualwallet.welcome.data.repository.datasource.LocalDatasource
import com.uzias.virtualwallet.welcome.data.repository.datasource.local.LocalDatasourceImpl
import com.uzias.virtualwallet.welcome.domain.repository.WelcomeRepository
import dagger.Module
import dagger.Provides

@Module
class WelcomeDataModule {

    @Provides fun providesWelcomeRepository(localDatasource: LocalDatasource): WelcomeRepository
            = WelcomeRepositoryImpl(localDatasource)

    @Provides fun providesLocalDatasource(): LocalDatasource = LocalDatasourceImpl()

}