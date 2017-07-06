package com.uzias.virtualwallet.user.domain.usecase

import com.uzias.virtualwallet.core.domain.UseCase
import io.reactivex.Completable

interface GenerateToken : UseCase<Completable>