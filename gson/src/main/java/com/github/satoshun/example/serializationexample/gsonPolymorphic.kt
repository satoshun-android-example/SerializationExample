package com.github.satoshun.example.serializationexample

import android.util.Log
import com.google.gson.GsonBuilder

fun testPolymorphic() {
  val factory = RuntimeTypeAdapterFactory
      .of(Animal::class.java)
      .registerSubtype(Dog::class.java)
      .registerSubtype(Cat::class.java)
  val gson = GsonBuilder()
      .registerTypeAdapterFactory(factory)
      .create()

  val dog = gson.fromJson(
      """
    {"animal":
      {
        "type": "Dog",
        "name": "dog",
        "height":30.2
      }
    }""".trimIndent(), Zoo::class.java
  )
  Log.d("dog", (dog.animal as Dog).height.toString())
}

data class Zoo(
  val animal: Animal
)

open class Animal(
  val name: String
)

class Dog(
  name: String,
  val height: Float
) : Animal(name)

class Cat(
  name: String,
  val weight: Float
) : Animal(name)
