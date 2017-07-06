package com.uzias.virtualwallet.user.presentation.mapper

import com.uzias.virtualwallet.core.mapper.BaseMapper
import com.uzias.virtualwallet.user.domain.model.User
import com.uzias.virtualwallet.user.presentation.model.PresentationUser

object PresentationUserMapper : BaseMapper<User, PresentationUser>() {

    override fun transformFrom(source: PresentationUser, disambiguate: Boolean): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun transformFrom(source: User): PresentationUser
            = PresentationUser(source.name, source.email)

}