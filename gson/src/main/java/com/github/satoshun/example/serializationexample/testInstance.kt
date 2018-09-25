package com.github.satoshun.example.serializationexample

import java.io.ObjectStreamClass

fun testInstance() {
  val getConstructorId = ObjectStreamClass::class.java
      .getDeclaredMethod("getConstructorId", Class::class.java)

  getConstructorId.isAccessible = true

  val constructorId = getConstructorId.invoke(null, Any::class.java) as Long

  val newInstance = ObjectStreamClass::class.java
      .getDeclaredMethod("newInstance", Class::class.java, Long::class.javaPrimitiveType)

  newInstance.isAccessible = true

  val hoge1 = newInstance.invoke(null, HogeInstance1::class.java, constructorId) as HogeInstance1
  hoge1.show()

//  val newInstance2 = ObjectInputStream::class.java
//      .getDeclaredMethod("newInstance", Class::class.java, Class::class.java)
//  newInstance2.isAccessible = true
//  val hoge2 = newInstance.invoke(null, Hoge::class.java, Any::class.java) as HogeInstance1
//  hoge2.show()
}

private class HogeInstance1 {
  fun show() {
    println("HogeInstance1")
  }
}

private class HogeInstance2(
) {
  fun show() {
    println("HogeInstance2ss")
  }
}
