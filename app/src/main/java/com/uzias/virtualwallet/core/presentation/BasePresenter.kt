package com.uzias.virtualwallet.core.presentation

interface BasePresenter {

    fun attachTo(view: BaseView)

    fun detachFrom(view: BaseView)

}
