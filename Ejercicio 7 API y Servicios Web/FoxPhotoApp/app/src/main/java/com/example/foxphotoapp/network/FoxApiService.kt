package com.example.foxphotoapp.network

import com.example.foxphotoapp.model.FoxPhoto
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://randomfox.ca/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory( Json.asConverterFactory("application/json".toMediaType()) )
    .baseUrl(BASE_URL)
    .build()

interface FoxApiService {
    @GET("floof/")
    suspend fun getPhoto(): FoxPhoto
}

object FoxApi {
    val retrofitService: FoxApiService by lazy {
        retrofit.create(FoxApiService::class.java)
    }
}

suspend fun fetchMultipleFoxPhotos(count: Int): List<FoxPhoto> = coroutineScope {
    val deferredPhotos = (1..count).map {
        async { FoxApi.retrofitService.getPhoto() }
    }
    deferredPhotos.awaitAll()
}