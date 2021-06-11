package com.dicoding.bangkit.android.expert.core.data.source.remote.network

import com.dicoding.bangkit.android.expert.core.data.source.remote.response.ListMadeCatalogueResponse
import retrofit2.http.GET

interface ApiService {

    @GET("list")
    suspend fun getListApi(): ListMadeCatalogueResponse
}