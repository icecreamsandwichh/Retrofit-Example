package com.dxn.retrofit.network

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.Query

interface NetworkService {
    @GET("posts")
    suspend fun get(): List<PostDto>
}