package com.github.satoshun.example.serializationexample.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
  @Json(name = "total_count") val totalCount: Count,
  @Json(name = "incomplete_results") val incompleteResults: Boolean,
  @Json(name = "items") val items: List<User>,
  @Json(name = "hoge") val hoge: List<User> = emptyList()
)

inline class Count(val count: Int)

@JsonClass(generateAdapter = true)
class User(
  @Json(name = "login") val login: String,
  @Json(name = "id") val id: Long,
  @Json(name = "url") val url: String,
  @Json(name = "html_url") val htmlUrl: String,
  @Json(name = "followers_url") val followersUrl: String,
  @Json(name = "following_url") val followingUrl: String,
  @Json(name = "starred_url") val starredUrl: String,
  @Json(name = "gists_url") val gistsUrl: String,
  @Json(name = "type") val type: String,
  @Json(name = "score") val score: Float
)
