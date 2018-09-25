package com.github.satoshun.example.serializationexample

import android.util.Log
import kotlin.system.measureTimeMillis

fun testAutoboxingPerformance() {
  // special field
  val rawType = Hoge::class.java
  val constructor = rawType.getDeclaredConstructor()
  val field = rawType.declaredFields[0]
  field.isAccessible = true

  val time2 = measureTimeMillis {
    for (i in 0..100000) {
      val h = constructor.newInstance()
      field.setInt(h, 100)
    }
  }
  Log.d("hogehoge2", time2.toString())

  val time = measureTimeMillis {
    for (i in 0..100000) {
      val h = constructor.newInstance()
      field.set(h, 100)
    }
  }
  Log.d("hogehoge1", time.toString())
}

class Hoge {
  val hoge: Int = 0
}
