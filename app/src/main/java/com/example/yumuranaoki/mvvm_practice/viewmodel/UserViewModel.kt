package com.example.yumuranaoki.mvvm_practice.viewmodel

import com.example.yumuranaoki.mvvm_practice.contract.UserViewContract
import com.example.yumuranaoki.mvvm_practice.model.api.UserApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserViewModel(val userView: UserViewContract) {
    fun onButtonClicked() {
        getUser()
    }

    private fun getUser() {
        // progressに関する処理
        val userObservable = UserApi.create().getUser()
        userObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result ->
                    val userName: String = result.name
                    userView.showUser(userName)
                }
    }
}