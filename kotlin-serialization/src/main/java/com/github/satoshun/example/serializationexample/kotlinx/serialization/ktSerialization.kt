package com.github.satoshun.example.serializationexample.kotlinx.serialization

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON

fun testKtSerialization() {
  val obj = JSON.parse<Hoge>("""{}""")
}

@Serializable
class Hoge
