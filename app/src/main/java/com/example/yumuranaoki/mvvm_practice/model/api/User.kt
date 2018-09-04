package com.example.yumuranaoki.mvvm_practice.model.api

import com.example.yumuranaoki.mvvm_practice.model.User
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserApi {
    @GET("users/1")
    fun getUser(): Observable<User>

    companion object {
        fun create(): UserApi {
            val retrofit =  Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:3000")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            val userApi = retrofit.create(UserApi::class.java)
            return userApi
        }
    }
}