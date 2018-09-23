object Vers {
  val compile_sdk = 28
  val min_sdk = 25
  val target_sdk = 28

  val kotlin = "1.3.0-rc-54"
  val couroutine = "0.26.1"
}

object Libs {
  val android_plugin = "com.android.tools.build:gradle:3.2.0-rc03"
  val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Vers.kotlin}"
  val kotlin_serialization_plugin = "org.jetbrains.kotlin:kotlin-serialization:${Vers.kotlin}"
  val dokka_plugin = "org.jetbrains.dokka:dokka-android-gradle-plugin:0.9.16"
  val safeargs_plugin = "android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0-alpha04"
  val versions_plugin = "com.github.ben-manes:gradle-versions-plugin:0.20.0"

  val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Vers.kotlin}"
  val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Vers.couroutine}"
  val ui_coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Vers.couroutine}"

  val ktx = "androidx.core:core-ktx:1.0.0"

  val appcompat = "androidx.appcompat:appcompat:1.0.0"
  val recyclerview = "androidx.recyclerview:recyclerview:1.0.0"
  val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.0-alpha2"

  val material = "com.google.android.material:material:1.0.0"

  val rxjava = "io.reactivex.rxjava2:rxjava:2.2.0"
  val rxandroid = "io.reactivex.rxjava2:rxandroid:2.1.0"

  val gson = "com.google.code.gson:gson:2.8.5"
  val moshi = "com.squareup.moshi:moshi:1.6.0"
  val moshi_codegen = "com.squareup.moshi:moshi-kotlin-codegen:1.6.0"
  val kotlin_serialization = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.8.0-rc13"

  val retrofit = "com.squareup.retrofit2:retrofit:2.4.0"
  val retrofit_gson = "com.squareup.retrofit2:converter-gson:2.4.0"
  val retrofit_moshi = "com.squareup.retrofit2:converter-moshi:2.4.0"
  val retrofit_kotlin_serialization = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.1.0"

  val retrofit_rxjava = "com.squareup.retrofit2:adapter-rxjava2:2.4.0"

  val okhttp = "com.squareup.okhttp3:okhttp:3.11.0"
}
