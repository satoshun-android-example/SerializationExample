package com.github.satoshun.example.serializationexample.moshi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.github.satoshun.example.serializationexample.GitHub
import com.github.satoshun.example.serializationexample.create
import com.squareup.moshi.Moshi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class MoshiMainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)

    Moshi.Builder()

    val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://api.github.com/")
        .build()

    val github = retrofit.create<GitHub>()
    github.search("satoshun")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            {
              Log.d("Result", it.toString())

              // use default value
              Log.d("Hoge", it.hoge.toString())
            },
            {
              Log.e("Error", it.message)
            }
        )
    testMoshi()
  }
}
