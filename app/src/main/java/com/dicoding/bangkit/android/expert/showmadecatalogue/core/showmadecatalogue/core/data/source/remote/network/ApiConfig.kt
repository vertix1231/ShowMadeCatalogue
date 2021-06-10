//package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.data.source.remote.network
//
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//object ApiConfig {
//
//    fun provideApiServiceMadeCatalogue():ApiService{
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://tourism-api.dicoding.dev/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        return retrofit.create(ApiService::class.java)
//    }
//}