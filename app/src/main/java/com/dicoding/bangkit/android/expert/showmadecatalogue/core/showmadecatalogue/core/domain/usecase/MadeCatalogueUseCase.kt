package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.domain.usecase

import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.data.Resource
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.domain.model.MadeCatalogue
import kotlinx.coroutines.flow.Flow

interface MadeCatalogueUseCase {

    fun getAllMadeCatalogue(): Flow<Resource<List<MadeCatalogue>>>
    fun getFavoriteMadeCatalogue(): Flow<List<MadeCatalogue>>
    fun setFavoriteMadeCatalogue(tourism: MadeCatalogue, state: Boolean)
}