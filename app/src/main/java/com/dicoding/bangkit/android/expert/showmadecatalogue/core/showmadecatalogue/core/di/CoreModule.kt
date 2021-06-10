package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.di

import androidx.room.Room
import com.dicoding.bangkit.android.expert.showmadecatalogue.BuildConfig
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.data.MadeCatalogueRepository
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.data.source.local.MadeCatalogueLocalDataSource
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.data.source.local.room.MadeCatalogueDatabase
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.data.source.remote.MadeCatalogueRemoteDataSource
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.data.source.remote.network.ApiService
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.domain.repository.IMadeCatalogueRepository
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<MadeCatalogueDatabase>().madeCatalogueDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            MadeCatalogueDatabase::class.java, "${BuildConfig.DATABASE_NAME}"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://tourism-api.dicoding.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { MadeCatalogueLocalDataSource(get()) }
    single { MadeCatalogueRemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IMadeCatalogueRepository> { MadeCatalogueRepository(get(), get(), get()) }
}