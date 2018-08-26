package com.github.satoshun.example.serializationexample

import com.github.satoshun.example.serializationexample.model.Result
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHub {
  @GET("search/users")
  fun search(
    @Query("q") query: String,
    @Query("page") page: Int = 1,
    @Query("per_page") perPage: Int = 20
  ): Single<Result>
}
