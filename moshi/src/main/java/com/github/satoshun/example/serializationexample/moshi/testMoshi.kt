package com.github.satoshun.example.serializationexample.moshi

import android.util.Log
import com.squareup.moshi.Moshi

fun testMoshi() {
  val moshi = Moshi.Builder().build()

  // nickname is null, ignore default value
  val g1 = moshi.adapter(User1::class.java).fromJson("""{"nickname":"hoge"}""")!!
  Log.d("User1", g1.nickname.toString())

  val hoge = moshi.adapter(Hoge::class.java).fromJson("""{}""")!!
  Log.d("Hoge", hoge.toString())
}

class Hoge constructor() {
  init {
    println("hogehoge")
  }
}

data class User1(
  val nickname: String? = "nickname",
  val age: Int = 10,
  val height: Int
) {
  init {
    println("User1")
  }
}

class User2(
  val nickname: String? = "nickname",
  val age: Int = 10,
  val height: Int = 150
)

class User3 {
  val nickname: String? = "nickname"
  val age: Int = 10
  lateinit var height: String
    private set
}
