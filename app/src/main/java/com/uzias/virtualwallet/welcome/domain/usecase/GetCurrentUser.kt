package com.uzias.virtualwallet.welcome.domain.usecase

import com.uzias.virtualwallet.core.domain.UseCase
import com.uzias.virtualwallet.welcome.domain.model.User
import io.reactivex.Observable

interface GetCurrentUser : UseCase<Observable<User>>