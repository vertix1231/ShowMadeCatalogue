package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.di.Injection
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.domain.usecase.MadeCatalogueUseCase
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.detail.DetailViewModel
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.favorite.FavoriteViewModel
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.home.HomeViewModel

class ViewModelFactory private constructor(private val madeCatalogueUseCase: MadeCatalogueUseCase) :
    ViewModelProvider.NewInstanceFactory(){

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance
                ?: synchronized(this) {
                    instance
                        ?: ViewModelFactory(
                            Injection.provideMadeCatalogueUseCase(
                                context
                            )
                        )
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(madeCatalogueUseCase) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(madeCatalogueUseCase) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(madeCatalogueUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}