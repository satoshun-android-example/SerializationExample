package com.github.satoshun.example.serializationexample

import android.util.Log
import com.google.gson.GsonBuilder

fun testGsonOptional() {
  val gson = GsonBuilder().create()

  // nickname is null, ignore default value
  val g1 = gson.fromJson<User1>("{}", User1::class.java)
  Log.d("user1", g1.nickname.toString())

  // nickname is nickname, consider default value
  val g2 = gson.fromJson<User2>("{}", User2::class.java)
  Log.d("user2", g2.nickname.toString())

  // nickname is nickname, consider default value
  val g3 = gson.fromJson<User3>("{}", User3::class.java)
  Log.d("user3", g3.nickname.toString())

  // nickname is null, doesn't consider default value
  val g4 = gson.fromJson<User4>("""{"height":"100.0a"}""", User4::class.java)
  Log.d("user4", g4.nickname.toString())
}

data class User1(
  val nickname: String? = "nickname",
  val age: Int = 10,
  val height: Int
)

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

class User4(
  val height: String
) {
  val nickname: String? = "nickname"
  val age: Int = 10
}
