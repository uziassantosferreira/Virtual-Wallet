package com.uzias.virtualwallet.core.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.uzias.virtualwallet.core.application.VirtualWalletApplication
import com.uzias.virtualwallet.core.di.AppComponent
import android.app.ProgressDialog
import com.uzias.virtualwallet.R


abstract class BaseActivity : AppCompatActivity(), BaseView {

    lateinit var progress: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        bindPresenter()
    }

    fun getAppComponent() : AppComponent {
        return (application as VirtualWalletApplication).component
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindPresenter()
    }

    override fun showLoading() {
        progress = ProgressDialog.show(this, getString(R.string.app_name),
                getString(R.string.loading), true);
    }

    override fun dismissLoading() {
        progress.dismiss()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
