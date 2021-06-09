package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.domain.usecase

import androidx.lifecycle.LiveData
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.data.MadeCatalogueRepository
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.data.Resource
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.domain.model.MadeCatalogue

class MadeCatalogueInteractor(private val madeCatalogueRepository: MadeCatalogueRepository):MadeCatalogueUseCase {
    override fun getAllMadeCatalogue(): LiveData<Resource<List<MadeCatalogue>>> {
       return madeCatalogueRepository.getAllMadeCatalogue()
    }

    override fun getFavoriteMadeCatalogue(): LiveData<List<MadeCatalogue>> {
        return madeCatalogueRepository.getFavoriteMadeCatalogue()
    }

    override fun setFavoriteMadeCatalogue(tourism: MadeCatalogue, state: Boolean) {
        return madeCatalogueRepository.setFavoriteMadeCatalogue(tourism,state)
    }
}