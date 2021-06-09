package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.domain.usecase

import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.data.MadeCatalogueRepository
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.data.Resource
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.domain.model.MadeCatalogue
import kotlinx.coroutines.flow.Flow

class MadeCatalogueInteractor(private val madeCatalogueRepository: MadeCatalogueRepository):MadeCatalogueUseCase {
    override fun getAllMadeCatalogue(): Flow<Resource<List<MadeCatalogue>>> {
       return madeCatalogueRepository.getAllMadeCatalogue()
    }

    override fun getFavoriteMadeCatalogue(): Flow<List<MadeCatalogue>> {
        return madeCatalogueRepository.getFavoriteMadeCatalogue()
    }

    override fun setFavoriteMadeCatalogue(tourism: MadeCatalogue, state: Boolean) {
        return madeCatalogueRepository.setFavoriteMadeCatalogue(tourism,state)
    }
}