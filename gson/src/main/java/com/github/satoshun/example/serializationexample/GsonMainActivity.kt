package com.github.satoshun.example.serializationexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type

class GsonMainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)

    val gson = GsonBuilder()
        .registerTypeAdapter(ScoreJsonDeserializer())
        .create()

    val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl("https://api.github.com/")
        .build()

    val github = retrofit.create<GitHub>()
    github.search("satoshun")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            {
              Log.d("Result", it.toString())

//              Log.d("Hoge", it.hoge.toString())
//              Log.d("Hoge2", it.hoge2.toString())
            },
            {
              Log.e("Error", it.message)
            }
        )

    testGsonOptional()
    testPolymorphic()
  }
}

data class Score(val score: Float)

class ScoreJsonDeserializer : JsonDeserializer<Score> {
  override fun deserialize(
    json: JsonElement,
    typeOfT: Type?,
    context: JsonDeserializationContext?
  ): Score {
    return Score(json.asFloat)
  }
}

inline fun <reified T> GsonBuilder.registerTypeAdapter(deserializer: JsonDeserializer<T>): GsonBuilder =
    registerTypeAdapter(T::class.java, deserializer)

inline fun <reified T> Retrofit.create(): T = create(T::class.java)
