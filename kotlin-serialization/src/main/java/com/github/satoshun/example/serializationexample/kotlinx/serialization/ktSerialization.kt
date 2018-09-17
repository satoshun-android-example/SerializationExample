package com.github.satoshun.example.serializationexample.kotlinx.serialization

import kotlinx.serialization.json.JSON

fun testKtSerialization() {
  val obj = JSON.parse<Hoge>("""{}""")
}

class Hoge
