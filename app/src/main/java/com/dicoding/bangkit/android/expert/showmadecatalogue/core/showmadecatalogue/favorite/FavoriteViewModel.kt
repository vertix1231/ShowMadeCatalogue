package com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.favorite

import androidx.lifecycle.ViewModel
import com.dicoding.bangkit.android.expert.showmadecatalogue.core.showmadecatalogue.core.domain.usecase.MadeCatalogueUseCase

class FavoriteViewModel(madeCatalogueUseCase: MadeCatalogueUseCase) : ViewModel() {

    val favoriteMadeCatalogue = madeCatalogueUseCase.getFavoriteMadeCatalogue()

}

