package com.uzias.virtualwallet.welcome.presentation.presenter

import com.uzias.virtualwallet.core.presentation.BasePresenter

interface WelcomePresenter : BasePresenter {
    fun clickedButtonSendMoney()
    fun clickedButtonShippingHistory()
}