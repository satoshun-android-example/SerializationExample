package com.github.satoshun.example.serializationexample.model

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
  @SerialName("total_count") val totalCount: Int,
  @SerialName("incomplete_results") val incompleteResults: Boolean,
  @SerialName("items") val items: List<User>,
  @Optional @SerialName("hoge") val hoge: List<User> = emptyList()
)

@Serializable
data class User(
  @SerialName("login") val login: String,
  @SerialName("id") val id: Long,
  @SerialName("url") val url: String,
  @SerialName("html_url") val htmlUrl: String,
  @SerialName("followers_url") val followersUrl: String,
  @SerialName("following_url") val followingUrl: String,
  @SerialName("starred_url") val starredUrl: String,
  @SerialName("gists_url") val gistsUrl: String,
  @SerialName("type") val type: String,
  @SerialName("score") val score: Float
)
