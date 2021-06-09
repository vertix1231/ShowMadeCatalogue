package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.di

import android.content.Context
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.data.MadeCatalogueRepository
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.data.source.local.MadeCatalogueLocalDataSource
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.data.source.local.room.MadeCatalogueDatabase
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.data.source.remote.MadeCatalogueRemoteDataSource
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.data.source.remote.network.ApiConfig
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.domain.repository.IMadeCatalogueRepository
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.domain.usecase.MadeCatalogueInteractor
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.domain.usecase.MadeCatalogueUseCase
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): IMadeCatalogueRepository {
        val database = MadeCatalogueDatabase.getInstance(context)

        val remoteDataSource = MadeCatalogueRemoteDataSource.getInstance(ApiConfig.provideApiServiceMadeCatalogue())
        val localDataSource = MadeCatalogueLocalDataSource.getInstance(database.madeCatalogueDao())
        val appExecutors = AppExecutors()

        return MadeCatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideMadeCatalogueUseCase(context: Context): MadeCatalogueUseCase {
        val repository = provideRepository(context)
        return MadeCatalogueInteractor(repository as MadeCatalogueRepository)
//        return MadeCatalogueInteractor(repository)
    }
}
