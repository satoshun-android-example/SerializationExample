package com.github.satoshun.example.serializationexample.model

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Type

data class Result(
  @SerializedName("total_count") val totalCount: Int,
  @SerializedName("incomplete_results") val incompleteResults: Boolean,
  @SerializedName("items") val items: List<User>,

    // NPE error when this field is access
    // gson ignore kotlin default value cuz constructor never execute
  @SerializedName("hoge") val hoge: List<User> = emptyList()
) {
  // NPE error when this field is access
  // gson ignore kotlin default value cuz constructor never execute
  @SerializedName("hoge2") val hoge2: List<User> = emptyList()
}

data class User(
  @SerializedName("login") val login: String,
  @SerializedName("id") val id: Long,
  @SerializedName("url") val url: String,
  @SerializedName("html_url") val htmlUrl: String,
  @SerializedName("followers_url") val followersUrl: String,
  @SerializedName("following_url") val followingUrl: String,
  @SerializedName("starred_url") val starredUrl: String,
  @SerializedName("gists_url") val gistsUrl: String,
  @SerializedName("type") val type: String,
  @SerializedName("score") val score: Score
)

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
