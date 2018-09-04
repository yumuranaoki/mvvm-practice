package com.example.yumuranaoki.mvvm_practice.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.yumuranaoki.mvvm_practice.R
import com.example.yumuranaoki.mvvm_practice.contract.UserViewContract
import com.example.yumuranaoki.mvvm_practice.databinding.ActivityMainBinding
import com.example.yumuranaoki.mvvm_practice.model.api.UserApi
import com.example.yumuranaoki.mvvm_practice.viewmodel.UserViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), UserViewContract {
    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = UserViewModel(this)
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    // 引数にuser classのデータが渡されるので、textViewに反映させる
    override fun showUser(userName: String) {
        val userNameText = findViewById<TextView>(R.id.userName)
        userNameText.text = userName
    }
}
