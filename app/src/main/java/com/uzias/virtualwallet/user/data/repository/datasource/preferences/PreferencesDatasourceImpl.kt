package com.uzias.virtualwallet.user.data.repository.datasource.preferences

import android.content.Context
import android.content.SharedPreferences
import com.uzias.virtualwallet.user.data.repository.datasource.PreferencesDatasource
import io.reactivex.Completable

class PreferencesDatasourceImpl(context: Context) : PreferencesDatasource {

    companion object {
        private val PREF_FILE = "Session"
        private val KEY_TOKEN = "token"
    }

    private val preferences: SharedPreferences

    override fun saveToken(token: String): Completable {
        preferences.edit().putString(KEY_TOKEN, token).apply()
        return Completable.complete()
    }

    override fun getToken(): Completable {
        val token = preferences.getString(KEY_TOKEN, "")

        if (token.isNullOrEmpty()){
            return Completable.error(Throwable("Not found token"))
        } else {
            return Completable.complete()
        }
    }

    init {
        preferences = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE)
    }


}