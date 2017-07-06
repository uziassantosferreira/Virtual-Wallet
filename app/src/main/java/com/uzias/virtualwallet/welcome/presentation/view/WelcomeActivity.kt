package com.uzias.virtualwallet.welcome.presentation.view

import android.os.Bundle
import com.uzias.virtualwallet.R
import com.uzias.virtualwallet.core.presentation.BaseActivity
import com.uzias.virtualwallet.core.presentation.BasePresenter
import com.uzias.virtualwallet.welcome.di.component.DaggerWelcomeComponent
import com.uzias.virtualwallet.user.presentation.model.PresentationUser
import com.uzias.virtualwallet.welcome.presentation.presenter.WelcomePresenter
import kotlinx.android.synthetic.main.activity_welcome.*
import javax.inject.Inject

class WelcomeActivity : BaseActivity(), WelcomeView {

    @Inject
    lateinit var presenter: WelcomePresenter

    private val viewName by lazy { textView_name }
    private val viewEmail by lazy { textView_email }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        assembleClickListeners()

    }

    private fun assembleClickListeners() {
        button_send_money.setOnClickListener { presenter.clickedButtonSendMoney() }
        button_shipping_history.setOnClickListener { presenter.clickedButtonShippingHistory() }
    }

    override fun getPresenter(): BasePresenter = presenter

    override fun injectDependencies() {
        DaggerWelcomeComponent.builder()
                .appComponent(getAppComponent())
                .build()
                .inject(this)
    }

    override fun setCurrentUser(user: PresentationUser) {
        viewName.text = user.name
        viewEmail.text = user.email
    }

}