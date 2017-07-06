package com.uzias.virtualwallet.welcome.presentation.view

import com.uzias.virtualwallet.core.presentation.BaseView
import com.uzias.virtualwallet.welcome.presentation.model.PresentationUser

interface WelcomeView : BaseView {

    fun setCurrentUser(user: PresentationUser)

}