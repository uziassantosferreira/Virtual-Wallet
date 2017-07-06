package com.uzias.virtualwallet.welcome.presentation.presenter

import com.uzias.virtualwallet.core.presentation.BaseView
import com.uzias.virtualwallet.user.domain.usecase.GenerateToken
import com.uzias.virtualwallet.user.domain.usecase.GetCurrentUser
import com.uzias.virtualwallet.user.presentation.mapper.PresentationUserMapper
import com.uzias.virtualwallet.welcome.presentation.navigation.Navigator
import com.uzias.virtualwallet.welcome.presentation.view.WelcomeView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class WelcomePresenterImpl(val getCurrentUser: GetCurrentUser,
                           val generateToken: GenerateToken,
                           val navigator: Navigator) : WelcomePresenter {

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
        generateToken(Action {
            view.dismissLoading()
            navigator.goToSendMoney()
        }, Consumer<Throwable> {
            view.dismissLoading()
            navigator.goToHistorySent()
        })
    }

    override fun clickedButtonShippingHistory() {
        view.showLoading()
        generateToken(Action {
            view.dismissLoading()
            navigator.goToHistorySent()
        }, Consumer<Throwable> { view.dismissLoading() })
    }

    private fun generateToken(onComplete: Action, error: Consumer<Throwable>){
        generateToken.run()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onComplete, error)
    }

}