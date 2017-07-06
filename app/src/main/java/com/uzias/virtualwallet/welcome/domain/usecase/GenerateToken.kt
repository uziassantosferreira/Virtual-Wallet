package com.uzias.virtualwallet.welcome.domain.usecase

import com.uzias.virtualwallet.core.domain.UseCase
import io.reactivex.Completable

interface GenerateToken : UseCase<Completable>