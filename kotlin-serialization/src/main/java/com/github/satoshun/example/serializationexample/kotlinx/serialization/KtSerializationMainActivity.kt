package com.github.satoshun.example.serializationexample.kotlinx.serialization

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.github.satoshun.example.serializationexample.GitHub
import com.github.satoshun.example.serializationexample.create
import com.jakewharton.retrofit2.converter.kotlinx.serialization.stringBased
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.serialization.json.JSON
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class KtSerializationMainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)

    val json = JSON.nonstrict // nonstrict mode
    val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(
            stringBased(
                MediaType.parse("application/json")!!,
                json::parse,
                json::stringify
            )
        )
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
  }
}
