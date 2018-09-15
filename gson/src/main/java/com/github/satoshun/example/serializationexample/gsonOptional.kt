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
