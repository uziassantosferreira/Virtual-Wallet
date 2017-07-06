package com.uzias.virtualwallet.user.domain.usecase

import com.uzias.virtualwallet.core.domain.UseCase
import com.uzias.virtualwallet.user.domain.model.User
import io.reactivex.Observable

interface GetCurrentUser : UseCase<Observable<User>>