package com.uzias.virtualwallet.user.di.module

import android.content.Context
import com.uzias.virtualwallet.user.data.repository.UserRepositoryImpl
import com.uzias.virtualwallet.user.data.repository.datasource.LocalDatasource
import com.uzias.virtualwallet.user.data.repository.datasource.NetworkingDatasource
import com.uzias.virtualwallet.user.data.repository.datasource.PreferencesDatasource
import com.uzias.virtualwallet.user.data.repository.datasource.local.LocalDatasourceImpl
import com.uzias.virtualwallet.user.data.repository.datasource.networking.NetworkingDatasourceImpl
import com.uzias.virtualwallet.user.data.repository.datasource.networking.service.UserService
import com.uzias.virtualwallet.user.data.repository.datasource.preferences.PreferencesDatasourceImpl
import com.uzias.virtualwallet.user.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class UserDataModule {

    @Provides fun providesWelcomeRepository(localDatasource: LocalDatasource,
                                            networkingDatasource: NetworkingDatasource,
                                            preferencesDatasource: PreferencesDatasource): UserRepository
            = UserRepositoryImpl(localDatasource, networkingDatasource, preferencesDatasource)

    @Provides fun providesLocalDatasource(): LocalDatasource = LocalDatasourceImpl()

    @Provides fun providesNetworkingDatasource(userService: UserService): NetworkingDatasource
            = NetworkingDatasourceImpl(userService)

    @Provides fun providesPreferencesDatasource(context: Context): PreferencesDatasource
            = PreferencesDatasourceImpl(context)

    @Provides fun providesWelcomeService(retrofit: Retrofit): UserService
            = retrofit.create(UserService::class.java)

}