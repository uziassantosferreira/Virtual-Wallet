package com.uzias.virtualwallet.welcome.presentation.presenter

import com.uzias.virtualwallet.core.presentation.BaseView
import com.uzias.virtualwallet.welcome.domain.usecase.GenerateToken
import com.uzias.virtualwallet.welcome.domain.usecase.GetCurrentUser
import com.uzias.virtualwallet.welcome.presentation.mapper.PresentationUserMapper
import com.uzias.virtualwallet.welcome.presentation.view.WelcomeView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class WelcomePresenterImpl(val getCurrentUser: GetCurrentUser,
                           val generateToken: GenerateToken) : WelcomePresenter {

    private var disposables = CompositeDisposable()
    private lateinit var view: WelcomeView

    override fun attachTo(view: BaseView) {
        initView(view)
        disposables.add(getCurrentUser())
    }

    private fun initView(view: BaseView) {
        if (view is WelcomeView) {
            this.view = view
        } else {
            throw IllegalArgumentException("WelcomePresenter requires a view of type WelcomeView")
        }
    }

    private fun getCurrentUser(): Disposable? {
        return getCurrentUser.run()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(PresentationUserMapper::transformFrom)
                .subscribe({ user ->
                    if (user != null){
                        view.setCurrentUser(user)
                    }else{
                        throw IllegalArgumentException("User cannot null")
                    }
                },{
                    throw RuntimeException(it)
                })
    }

    override fun detachFrom(view: BaseView) {
        disposables.clear()
    }

    override fun clickedButtonSendMoney() {
        view.showLoading()

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clickedButtonShippingHistory() {
        view.showLoading()
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}